// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HomeChangeEditModeRsp.proto

package emu.grasscutter.net.proto;

public final class HomeChangeEditModeRspOuterClass {
  private HomeChangeEditModeRspOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface HomeChangeEditModeRspOrBuilder extends
      // @@protoc_insertion_point(interface_extends:HomeChangeEditModeRsp)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>bool is_enter_edit_mode = 9;</code>
     * @return The isEnterEditMode.
     */
    boolean getIsEnterEditMode();

    /**
     * <code>int32 retcode = 11;</code>
     * @return The retcode.
     */
    int getRetcode();
  }
  /**
   * <pre>
   * CmdId: 27049
   * </pre>
   *
   * Protobuf type {@code HomeChangeEditModeRsp}
   */
  public static final class HomeChangeEditModeRsp extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:HomeChangeEditModeRsp)
      HomeChangeEditModeRspOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use HomeChangeEditModeRsp.newBuilder() to construct.
    private HomeChangeEditModeRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private HomeChangeEditModeRsp() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new HomeChangeEditModeRsp();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private HomeChangeEditModeRsp(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 72: {

              isEnterEditMode_ = input.readBool();
              break;
            }
            case 88: {

              retcode_ = input.readInt32();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.internal_static_HomeChangeEditModeRsp_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.internal_static_HomeChangeEditModeRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp.class, emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp.Builder.class);
    }

    public static final int IS_ENTER_EDIT_MODE_FIELD_NUMBER = 9;
    private boolean isEnterEditMode_;
    /**
     * <code>bool is_enter_edit_mode = 9;</code>
     * @return The isEnterEditMode.
     */
    @java.lang.Override
    public boolean getIsEnterEditMode() {
      return isEnterEditMode_;
    }

    public static final int RETCODE_FIELD_NUMBER = 11;
    private int retcode_;
    /**
     * <code>int32 retcode = 11;</code>
     * @return The retcode.
     */
    @java.lang.Override
    public int getRetcode() {
      return retcode_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (isEnterEditMode_ != false) {
        output.writeBool(9, isEnterEditMode_);
      }
      if (retcode_ != 0) {
        output.writeInt32(11, retcode_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (isEnterEditMode_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(9, isEnterEditMode_);
      }
      if (retcode_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(11, retcode_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp)) {
        return super.equals(obj);
      }
      emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp other = (emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp) obj;

      if (getIsEnterEditMode()
          != other.getIsEnterEditMode()) return false;
      if (getRetcode()
          != other.getRetcode()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + IS_ENTER_EDIT_MODE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsEnterEditMode());
      hash = (37 * hash) + RETCODE_FIELD_NUMBER;
      hash = (53 * hash) + getRetcode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * <pre>
     * CmdId: 27049
     * </pre>
     *
     * Protobuf type {@code HomeChangeEditModeRsp}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:HomeChangeEditModeRsp)
        emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRspOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.internal_static_HomeChangeEditModeRsp_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.internal_static_HomeChangeEditModeRsp_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp.class, emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp.Builder.class);
      }

      // Construct using emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        isEnterEditMode_ = false;

        retcode_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.internal_static_HomeChangeEditModeRsp_descriptor;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp getDefaultInstanceForType() {
        return emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp.getDefaultInstance();
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp build() {
        emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp buildPartial() {
        emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp result = new emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp(this);
        result.isEnterEditMode_ = isEnterEditMode_;
        result.retcode_ = retcode_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp) {
          return mergeFrom((emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp other) {
        if (other == emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp.getDefaultInstance()) return this;
        if (other.getIsEnterEditMode() != false) {
          setIsEnterEditMode(other.getIsEnterEditMode());
        }
        if (other.getRetcode() != 0) {
          setRetcode(other.getRetcode());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private boolean isEnterEditMode_ ;
      /**
       * <code>bool is_enter_edit_mode = 9;</code>
       * @return The isEnterEditMode.
       */
      @java.lang.Override
      public boolean getIsEnterEditMode() {
        return isEnterEditMode_;
      }
      /**
       * <code>bool is_enter_edit_mode = 9;</code>
       * @param value The isEnterEditMode to set.
       * @return This builder for chaining.
       */
      public Builder setIsEnterEditMode(boolean value) {
        
        isEnterEditMode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool is_enter_edit_mode = 9;</code>
       * @return This builder for chaining.
       */
      public Builder clearIsEnterEditMode() {
        
        isEnterEditMode_ = false;
        onChanged();
        return this;
      }

      private int retcode_ ;
      /**
       * <code>int32 retcode = 11;</code>
       * @return The retcode.
       */
      @java.lang.Override
      public int getRetcode() {
        return retcode_;
      }
      /**
       * <code>int32 retcode = 11;</code>
       * @param value The retcode to set.
       * @return This builder for chaining.
       */
      public Builder setRetcode(int value) {
        
        retcode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 retcode = 11;</code>
       * @return This builder for chaining.
       */
      public Builder clearRetcode() {
        
        retcode_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:HomeChangeEditModeRsp)
    }

    // @@protoc_insertion_point(class_scope:HomeChangeEditModeRsp)
    private static final emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp();
    }

    public static emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<HomeChangeEditModeRsp>
        PARSER = new com.google.protobuf.AbstractParser<HomeChangeEditModeRsp>() {
      @java.lang.Override
      public HomeChangeEditModeRsp parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new HomeChangeEditModeRsp(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<HomeChangeEditModeRsp> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<HomeChangeEditModeRsp> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_HomeChangeEditModeRsp_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_HomeChangeEditModeRsp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033HomeChangeEditModeRsp.proto\"D\n\025HomeCha" +
      "ngeEditModeRsp\022\032\n\022is_enter_edit_mode\030\t \001" +
      "(\010\022\017\n\007retcode\030\013 \001(\005B\033\n\031emu.grasscutter.n" +
      "et.protob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_HomeChangeEditModeRsp_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_HomeChangeEditModeRsp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_HomeChangeEditModeRsp_descriptor,
        new java.lang.String[] { "IsEnterEditMode", "Retcode", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
