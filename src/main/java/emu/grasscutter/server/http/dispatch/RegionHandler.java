package emu.grasscutter.server.http.dispatch;

import ch.qos.logback.classic.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.protobuf.ByteString;
import emu.grasscutter.GameConstants;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.ConfigContainer;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass;
import emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass;
import emu.grasscutter.net.proto.RegionInfoOuterClass;
import emu.grasscutter.net.proto.RegionSimpleInfoOuterClass;
import emu.grasscutter.net.proto.ResVersionConfigOuterClass;
import emu.grasscutter.net.proto.StopServerInfoOuterClass;
import emu.grasscutter.server.event.dispatch.QueryAllRegionsEvent;
import emu.grasscutter.server.event.dispatch.QueryCurrentRegionEvent;
import emu.grasscutter.server.http.Router;
import emu.grasscutter.server.http.dispatch.Kaguya;
import emu.grasscutter.server.http.objects.QueryCurRegionRspJson;
import emu.grasscutter.utils.Crypto;
import emu.grasscutter.utils.JsonUtils;
import emu.grasscutter.utils.Utils;
import io.javalin.Javalin;
import io.javalin.http.Context;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class RegionHandler
implements Router {
    private static final Map<String, RegionData> regions = new ConcurrentHashMap<String, RegionData>();
    private static String regionListResponse;
    private static String regionListResponseCN;

    public RegionHandler() {
        try {
            this.initialize();
        } catch (Exception exception) {
            Grasscutter.getLogger().error("Failed to initialize region data.", exception);
        }
    }

    private void initialize() {
        String dispatchDomain = "http" + (Configuration.HTTP_ENCRYPTION.useInRouting ? "s" : "") + "://" + Configuration.lr(Configuration.HTTP_INFO.accessAddress, Configuration.HTTP_INFO.bindAddress) + ":" + Configuration.lr(Configuration.HTTP_INFO.accessPort, Configuration.HTTP_INFO.bindPort);
        ArrayList servers = new ArrayList();
        ArrayList usedNames = new ArrayList();
        ArrayList<ConfigContainer.Region> configuredRegions = new ArrayList<ConfigContainer.Region>(Configuration.DISPATCH_INFO.regions);
        if (Grasscutter.getRunMode() != Grasscutter.ServerRunMode.HYBRID && configuredRegions.size() == 0) {
            Grasscutter.getLogger().error("[Dispatch] There are no game servers available. Exiting due to unplayable state.");
            System.exit(1);
        } else if (configuredRegions.size() == 0) {
            configuredRegions.add(new ConfigContainer.Region("os_usa", Configuration.DISPATCH_INFO.defaultName, Configuration.lr(Configuration.GAME_INFO.accessAddress, Configuration.GAME_INFO.bindAddress), Configuration.lr(Configuration.GAME_INFO.accessPort, Configuration.GAME_INFO.bindPort)));
        }
        configuredRegions.forEach(region -> {
            if (usedNames.contains(region.Name)) {
                Grasscutter.getLogger().error("Region name already in use.");
                return;
            }
            RegionSimpleInfoOuterClass.RegionSimpleInfo identifier = RegionSimpleInfoOuterClass.RegionSimpleInfo.newBuilder().setName(region.Name).setTitle(region.Title).setType("DEV_PUBLIC").setDispatchUrl(dispatchDomain + "/query_cur_region/" + region.Name).build();
            usedNames.add(region.Name);
            servers.add(identifier);
            Kaguya.Resource kkk = new Kaguya.Resource();
            RegionInfoOuterClass.RegionInfo regionInfo = RegionInfoOuterClass.RegionInfo.newBuilder().setGateserverIp(region.Ip).setGateserverPort(region.Port).setResourceUrl(kkk.resourceUrl).setDataUrl(kkk.dataUrl).setResourceUrlBak(kkk.resourceUrlBak).setClientDataVersion(kkk.clientDataVersion).setClientSilenceDataVersion(kkk.clientSilenceDataVersion).setClientDataMd5(kkk.clientDataMd5).setClientSilenceDataMd5(kkk.clientSilenceDataMd5).setResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig.newBuilder().setVersion(kkk.resVersionConfig.version).setMd5(kkk.resVersionConfig.md5).setReleaseTotalSize(kkk.resVersionConfig.releaseTotalSize).setVersionSuffix(kkk.resVersionConfig.versionSuffix).setBranch(kkk.resVersionConfig.branch).build()).setClientVersionSuffix(kkk.clientVersionSuffix).setClientSilenceVersionSuffix(kkk.clientSilenceVersionSuffix).setNextResourceUrl(kkk.nextResourceUrl).setNextResVersionConfig(ResVersionConfigOuterClass.ResVersionConfig.newBuilder().setVersion(kkk.nextResVersionConfig.version).setMd5(kkk.nextResVersionConfig.md5).setReleaseTotalSize(kkk.nextResVersionConfig.releaseTotalSize).setVersionSuffix(kkk.nextResVersionConfig.versionSuffix).setBranch(kkk.nextResVersionConfig.branch)).build();
            QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp updatedQuery = QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp.newBuilder().setRegionInfo(regionInfo).setClientSecretKey(ByteString.copyFrom(Crypto.DISPATCH_SEED)).build();
            regions.put(region.Name, new RegionData(updatedQuery, Utils.base64Encode(updatedQuery.toByteString().toByteArray())));
        });
        JsonArray hiddenIcons = new JsonArray();
        hiddenIcons.add(40);
        JsonArray codeSwitch = new JsonArray();
        codeSwitch.add(3628);
        JsonObject customConfig = new JsonObject();
        customConfig.addProperty("sdkenv", "2");
        customConfig.addProperty("checkdevice", "false");
        customConfig.addProperty("loadPatch", "false");
        customConfig.addProperty("showexception", String.valueOf(GameConstants.DEBUG));
        customConfig.addProperty("regionConfig", "pm|fk|add");
        customConfig.addProperty("downloadMode", "0");
        customConfig.add("codeSwitch", codeSwitch);
        customConfig.add("coverSwitch", hiddenIcons);
        byte[] encodedConfig = JsonUtils.encode(customConfig).getBytes();
        Crypto.xor(encodedConfig, Crypto.DISPATCH_KEY);
        QueryRegionListHttpRspOuterClass.QueryRegionListHttpRsp updatedRegionList = QueryRegionListHttpRspOuterClass.QueryRegionListHttpRsp.newBuilder().addAllRegionList(servers).setClientSecretKey(ByteString.copyFrom(Crypto.DISPATCH_SEED)).setClientCustomConfigEncrypted(ByteString.copyFrom(encodedConfig)).setEnableLoginPc(true).build();
        regionListResponse = Utils.base64Encode(updatedRegionList.toByteString().toByteArray());
        customConfig.addProperty("sdkenv", "0");
        encodedConfig = JsonUtils.encode(customConfig).getBytes();
        Crypto.xor(encodedConfig, Crypto.DISPATCH_KEY);
        QueryRegionListHttpRspOuterClass.QueryRegionListHttpRsp updatedRegionListCN = QueryRegionListHttpRspOuterClass.QueryRegionListHttpRsp.newBuilder().addAllRegionList(servers).setClientSecretKey(ByteString.copyFrom(Crypto.DISPATCH_SEED)).setClientCustomConfigEncrypted(ByteString.copyFrom(encodedConfig)).setEnableLoginPc(true).build();
        regionListResponseCN = Utils.base64Encode(updatedRegionListCN.toByteString().toByteArray());
    }

    @Override
    public void applyRoutes(Javalin javalin) {
        javalin.get("/query_region_list", RegionHandler::queryRegionList);
        javalin.get("/query_cur_region/{region}", RegionHandler::queryCurrentRegion);
    }

    private static void queryRegionList(Context ctx) {
        Logger logger = Grasscutter.getLogger();
        if (ctx.queryParamMap().containsKey("version") && ctx.queryParamMap().containsKey("platform")) {
            String versionName = ctx.queryParam("version");
            String versionCode = versionName.substring(0, 8);
            String platformName = ctx.queryParam("platform");
            if ("CNRELiOS".equals(versionCode) || "CNRELWin".equals(versionCode) || "CNRELAnd".equals(versionCode)) {
                QueryAllRegionsEvent event = new QueryAllRegionsEvent(regionListResponseCN);
                event.call();
                ctx.result(event.getRegionList());
            } else if ("OSRELiOS".equals(versionCode) || "OSRELWin".equals(versionCode) || "OSRELAnd".equals(versionCode)) {
                QueryAllRegionsEvent event = new QueryAllRegionsEvent(regionListResponse);
                event.call();
                ctx.result(event.getRegionList());
            } else {
                QueryAllRegionsEvent event = new QueryAllRegionsEvent(regionListResponse);
                event.call();
                ctx.result(event.getRegionList());
            }
        } else {
            QueryAllRegionsEvent event = new QueryAllRegionsEvent(regionListResponse);
            event.call();
            ctx.result(event.getRegionList());
        }
        Grasscutter.getLogger().info(String.format("[Dispatch] Client %s request: query_region_list", Utils.address(ctx)));
    }

    private static void queryCurrentRegion(Context ctx) {
        String regionName = ctx.pathParam("region");
        String versionName = ctx.queryParam("version");
        RegionData region = regions.get(regionName);
        String regionData = "CAESGE5vdCBGb3VuZCB2ZXJzaW9uIGNvbmZpZw==";
        if (!ctx.queryParamMap().values().isEmpty() && region != null) {
            regionData = region.getBase64();
        }
        String clientVersion = versionName.replaceAll(Pattern.compile("[a-zA-Z]").pattern(), "");
        String[] versionCode = clientVersion.split("\\.");
        int versionMajor = Integer.parseInt(versionCode[0]);
        int versionMinor = Integer.parseInt(versionCode[1]);
        int versionFix = Integer.parseInt(versionCode[2]);
        if (versionMajor >= 3 || versionMajor == 2 && versionMinor == 7 && versionFix >= 50 || versionMajor == 2 && versionMinor == 8) {
            try {
                QueryCurrentRegionEvent event = new QueryCurrentRegionEvent(regionData);
                event.call();
                String key_id = ctx.queryParam("key_id");
                if (versionMajor != GameConstants.VERSION_PARTS[0] || versionMinor != GameConstants.VERSION_PARTS[1]) {
                    boolean updateClient = GameConstants.VERSION.compareTo(clientVersion) > 0;
                    QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp rsp = QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp.newBuilder().setRetcode(11).setMsg("Connection Failed!").setRegionInfo(RegionInfoOuterClass.RegionInfo.newBuilder()).setStopServer(StopServerInfoOuterClass.StopServerInfo.newBuilder().setUrl("https://discord.gg/T5vZU6UyeG").setStopBeginTime((int)Instant.now().getEpochSecond()).setStopEndTime((int)Instant.now().getEpochSecond() + 1).setContentMsg(updateClient ? "\nVersion mismatch outdated client! \n\nServer version: %s\nClient version: %s".formatted(new Object[]{GameConstants.VERSION, clientVersion}) : "\nVersion mismatch outdated server! \n\nServer version: %s\nClient version: %s".formatted(new Object[]{GameConstants.VERSION, clientVersion})).build()).buildPartial();
                    Grasscutter.getLogger().debug(String.format("Connection denied for %s due to %s.", Utils.address(ctx), updateClient ? "outdated client!" : "outdated server!"));
                    ctx.json(Crypto.encryptAndSignRegionData(rsp.toByteArray(), key_id));
                    return;
                }
                if (ctx.queryParam("dispatchSeed") == null) {
                    QueryCurRegionRspJson rsp = new QueryCurRegionRspJson();
                    rsp.content = event.getRegionInfo();
                    rsp.sign = "TW9yZSBsb3ZlIGZvciBVQSBQYXRjaCBwbGF5ZXJz";
                    ctx.json(rsp);
                    return;
                }
                byte[] regionInfo = Utils.base64Decode(event.getRegionInfo());
                ctx.json(Crypto.encryptAndSignRegionData(regionInfo, key_id));
            } catch (Exception e) {
                Grasscutter.getLogger().error("An error occurred while handling query_cur_region.", e);
            }
        } else {
            QueryCurrentRegionEvent event = new QueryCurrentRegionEvent(regionData);
            event.call();
            ctx.result(event.getRegionInfo());
        }
        Grasscutter.getLogger().info(String.format("Client %s request: query_cur_region/%s", Utils.address(ctx), regionName));
    }

    public static QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp getCurrentRegion() {
        return Grasscutter.getRunMode() == Grasscutter.ServerRunMode.HYBRID ? regions.get("os_usa").getRegionQuery() : null;
    }

    public static class RegionData {
        private final QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp regionQuery;
        private final String base64;

        public RegionData(QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp prq, String b64) {
            this.regionQuery = prq;
            this.base64 = b64;
        }

        public QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp getRegionQuery() {
            return this.regionQuery;
        }

        public String getBase64() {
            return this.base64;
        }
    }
}

