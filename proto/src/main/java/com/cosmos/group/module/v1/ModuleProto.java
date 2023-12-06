// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cosmos/group/module/v1/module.proto

package com.cosmos.group.module.v1;

public final class ModuleProto {
  private ModuleProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ModuleOrBuilder extends
      // @@protoc_insertion_point(interface_extends:cosmos.group.module.v1.Module)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
     * to execute the proposal.
     * </pre>
     *
     * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
     * @return Whether the maxExecutionPeriod field is set.
     */
    boolean hasMaxExecutionPeriod();
    /**
     * <pre>
     * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
     * to execute the proposal.
     * </pre>
     *
     * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
     * @return The maxExecutionPeriod.
     */
    com.google.protobuf.Duration getMaxExecutionPeriod();
    /**
     * <pre>
     * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
     * to execute the proposal.
     * </pre>
     *
     * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
     */
    com.google.protobuf.DurationOrBuilder getMaxExecutionPeriodOrBuilder();

    /**
     * <pre>
     * max_metadata_len defines the max length of the metadata bytes field for various entities within the group module.
     * Defaults to 255 if not explicitly set.
     * </pre>
     *
     * <code>uint64 max_metadata_len = 2 [json_name = "maxMetadataLen"];</code>
     * @return The maxMetadataLen.
     */
    long getMaxMetadataLen();
  }
  /**
   * <pre>
   * Module is the config object of the group module.
   * </pre>
   *
   * Protobuf type {@code cosmos.group.module.v1.Module}
   */
  public static final class Module extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:cosmos.group.module.v1.Module)
      ModuleOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Module.newBuilder() to construct.
    private Module(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Module() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Module();
    }

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.cosmos.group.module.v1.ModuleProto.internal_static_cosmos_group_module_v1_Module_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.cosmos.group.module.v1.ModuleProto.internal_static_cosmos_group_module_v1_Module_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.cosmos.group.module.v1.ModuleProto.Module.class, com.cosmos.group.module.v1.ModuleProto.Module.Builder.class);
    }

    public static final int MAX_EXECUTION_PERIOD_FIELD_NUMBER = 1;
    private com.google.protobuf.Duration maxExecutionPeriod_;
    /**
     * <pre>
     * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
     * to execute the proposal.
     * </pre>
     *
     * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
     * @return Whether the maxExecutionPeriod field is set.
     */
    @java.lang.Override
    public boolean hasMaxExecutionPeriod() {
      return maxExecutionPeriod_ != null;
    }
    /**
     * <pre>
     * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
     * to execute the proposal.
     * </pre>
     *
     * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
     * @return The maxExecutionPeriod.
     */
    @java.lang.Override
    public com.google.protobuf.Duration getMaxExecutionPeriod() {
      return maxExecutionPeriod_ == null ? com.google.protobuf.Duration.getDefaultInstance() : maxExecutionPeriod_;
    }
    /**
     * <pre>
     * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
     * to execute the proposal.
     * </pre>
     *
     * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
     */
    @java.lang.Override
    public com.google.protobuf.DurationOrBuilder getMaxExecutionPeriodOrBuilder() {
      return maxExecutionPeriod_ == null ? com.google.protobuf.Duration.getDefaultInstance() : maxExecutionPeriod_;
    }

    public static final int MAX_METADATA_LEN_FIELD_NUMBER = 2;
    private long maxMetadataLen_ = 0L;
    /**
     * <pre>
     * max_metadata_len defines the max length of the metadata bytes field for various entities within the group module.
     * Defaults to 255 if not explicitly set.
     * </pre>
     *
     * <code>uint64 max_metadata_len = 2 [json_name = "maxMetadataLen"];</code>
     * @return The maxMetadataLen.
     */
    @java.lang.Override
    public long getMaxMetadataLen() {
      return maxMetadataLen_;
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
      if (maxExecutionPeriod_ != null) {
        output.writeMessage(1, getMaxExecutionPeriod());
      }
      if (maxMetadataLen_ != 0L) {
        output.writeUInt64(2, maxMetadataLen_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (maxExecutionPeriod_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getMaxExecutionPeriod());
      }
      if (maxMetadataLen_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(2, maxMetadataLen_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.cosmos.group.module.v1.ModuleProto.Module)) {
        return super.equals(obj);
      }
      com.cosmos.group.module.v1.ModuleProto.Module other = (com.cosmos.group.module.v1.ModuleProto.Module) obj;

      if (hasMaxExecutionPeriod() != other.hasMaxExecutionPeriod()) return false;
      if (hasMaxExecutionPeriod()) {
        if (!getMaxExecutionPeriod()
            .equals(other.getMaxExecutionPeriod())) return false;
      }
      if (getMaxMetadataLen()
          != other.getMaxMetadataLen()) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasMaxExecutionPeriod()) {
        hash = (37 * hash) + MAX_EXECUTION_PERIOD_FIELD_NUMBER;
        hash = (53 * hash) + getMaxExecutionPeriod().hashCode();
      }
      hash = (37 * hash) + MAX_METADATA_LEN_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getMaxMetadataLen());
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.cosmos.group.module.v1.ModuleProto.Module parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.cosmos.group.module.v1.ModuleProto.Module parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.cosmos.group.module.v1.ModuleProto.Module parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.cosmos.group.module.v1.ModuleProto.Module parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.cosmos.group.module.v1.ModuleProto.Module parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.cosmos.group.module.v1.ModuleProto.Module parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.cosmos.group.module.v1.ModuleProto.Module parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.cosmos.group.module.v1.ModuleProto.Module parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.cosmos.group.module.v1.ModuleProto.Module parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }

    public static com.cosmos.group.module.v1.ModuleProto.Module parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.cosmos.group.module.v1.ModuleProto.Module parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.cosmos.group.module.v1.ModuleProto.Module parseFrom(
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
    public static Builder newBuilder(com.cosmos.group.module.v1.ModuleProto.Module prototype) {
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
     * Module is the config object of the group module.
     * </pre>
     *
     * Protobuf type {@code cosmos.group.module.v1.Module}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:cosmos.group.module.v1.Module)
        com.cosmos.group.module.v1.ModuleProto.ModuleOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.cosmos.group.module.v1.ModuleProto.internal_static_cosmos_group_module_v1_Module_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.cosmos.group.module.v1.ModuleProto.internal_static_cosmos_group_module_v1_Module_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.cosmos.group.module.v1.ModuleProto.Module.class, com.cosmos.group.module.v1.ModuleProto.Module.Builder.class);
      }

      // Construct using com.cosmos.group.module.v1.ModuleProto.Module.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        bitField0_ = 0;
        maxExecutionPeriod_ = null;
        if (maxExecutionPeriodBuilder_ != null) {
          maxExecutionPeriodBuilder_.dispose();
          maxExecutionPeriodBuilder_ = null;
        }
        maxMetadataLen_ = 0L;
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.cosmos.group.module.v1.ModuleProto.internal_static_cosmos_group_module_v1_Module_descriptor;
      }

      @java.lang.Override
      public com.cosmos.group.module.v1.ModuleProto.Module getDefaultInstanceForType() {
        return com.cosmos.group.module.v1.ModuleProto.Module.getDefaultInstance();
      }

      @java.lang.Override
      public com.cosmos.group.module.v1.ModuleProto.Module build() {
        com.cosmos.group.module.v1.ModuleProto.Module result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.cosmos.group.module.v1.ModuleProto.Module buildPartial() {
        com.cosmos.group.module.v1.ModuleProto.Module result = new com.cosmos.group.module.v1.ModuleProto.Module(this);
        if (bitField0_ != 0) { buildPartial0(result); }
        onBuilt();
        return result;
      }

      private void buildPartial0(com.cosmos.group.module.v1.ModuleProto.Module result) {
        int from_bitField0_ = bitField0_;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.maxExecutionPeriod_ = maxExecutionPeriodBuilder_ == null
              ? maxExecutionPeriod_
              : maxExecutionPeriodBuilder_.build();
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          result.maxMetadataLen_ = maxMetadataLen_;
        }
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
        if (other instanceof com.cosmos.group.module.v1.ModuleProto.Module) {
          return mergeFrom((com.cosmos.group.module.v1.ModuleProto.Module)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.cosmos.group.module.v1.ModuleProto.Module other) {
        if (other == com.cosmos.group.module.v1.ModuleProto.Module.getDefaultInstance()) return this;
        if (other.hasMaxExecutionPeriod()) {
          mergeMaxExecutionPeriod(other.getMaxExecutionPeriod());
        }
        if (other.getMaxMetadataLen() != 0L) {
          setMaxMetadataLen(other.getMaxMetadataLen());
        }
        this.mergeUnknownFields(other.getUnknownFields());
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
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 10: {
                input.readMessage(
                    getMaxExecutionPeriodFieldBuilder().getBuilder(),
                    extensionRegistry);
                bitField0_ |= 0x00000001;
                break;
              } // case 10
              case 16: {
                maxMetadataLen_ = input.readUInt64();
                bitField0_ |= 0x00000002;
                break;
              } // case 16
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }
      private int bitField0_;

      private com.google.protobuf.Duration maxExecutionPeriod_;
      private com.google.protobuf.SingleFieldBuilderV3<
          com.google.protobuf.Duration, com.google.protobuf.Duration.Builder, com.google.protobuf.DurationOrBuilder> maxExecutionPeriodBuilder_;
      /**
       * <pre>
       * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
       * to execute the proposal.
       * </pre>
       *
       * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
       * @return Whether the maxExecutionPeriod field is set.
       */
      public boolean hasMaxExecutionPeriod() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <pre>
       * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
       * to execute the proposal.
       * </pre>
       *
       * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
       * @return The maxExecutionPeriod.
       */
      public com.google.protobuf.Duration getMaxExecutionPeriod() {
        if (maxExecutionPeriodBuilder_ == null) {
          return maxExecutionPeriod_ == null ? com.google.protobuf.Duration.getDefaultInstance() : maxExecutionPeriod_;
        } else {
          return maxExecutionPeriodBuilder_.getMessage();
        }
      }
      /**
       * <pre>
       * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
       * to execute the proposal.
       * </pre>
       *
       * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
       */
      public Builder setMaxExecutionPeriod(com.google.protobuf.Duration value) {
        if (maxExecutionPeriodBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          maxExecutionPeriod_ = value;
        } else {
          maxExecutionPeriodBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
       * to execute the proposal.
       * </pre>
       *
       * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
       */
      public Builder setMaxExecutionPeriod(
          com.google.protobuf.Duration.Builder builderForValue) {
        if (maxExecutionPeriodBuilder_ == null) {
          maxExecutionPeriod_ = builderForValue.build();
        } else {
          maxExecutionPeriodBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
       * to execute the proposal.
       * </pre>
       *
       * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
       */
      public Builder mergeMaxExecutionPeriod(com.google.protobuf.Duration value) {
        if (maxExecutionPeriodBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0) &&
            maxExecutionPeriod_ != null &&
            maxExecutionPeriod_ != com.google.protobuf.Duration.getDefaultInstance()) {
            getMaxExecutionPeriodBuilder().mergeFrom(value);
          } else {
            maxExecutionPeriod_ = value;
          }
        } else {
          maxExecutionPeriodBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
       * to execute the proposal.
       * </pre>
       *
       * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
       */
      public Builder clearMaxExecutionPeriod() {
        bitField0_ = (bitField0_ & ~0x00000001);
        maxExecutionPeriod_ = null;
        if (maxExecutionPeriodBuilder_ != null) {
          maxExecutionPeriodBuilder_.dispose();
          maxExecutionPeriodBuilder_ = null;
        }
        onChanged();
        return this;
      }
      /**
       * <pre>
       * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
       * to execute the proposal.
       * </pre>
       *
       * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
       */
      public com.google.protobuf.Duration.Builder getMaxExecutionPeriodBuilder() {
        bitField0_ |= 0x00000001;
        onChanged();
        return getMaxExecutionPeriodFieldBuilder().getBuilder();
      }
      /**
       * <pre>
       * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
       * to execute the proposal.
       * </pre>
       *
       * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
       */
      public com.google.protobuf.DurationOrBuilder getMaxExecutionPeriodOrBuilder() {
        if (maxExecutionPeriodBuilder_ != null) {
          return maxExecutionPeriodBuilder_.getMessageOrBuilder();
        } else {
          return maxExecutionPeriod_ == null ?
              com.google.protobuf.Duration.getDefaultInstance() : maxExecutionPeriod_;
        }
      }
      /**
       * <pre>
       * max_execution_period defines the max duration after a proposal's voting period ends that members can send a MsgExec
       * to execute the proposal.
       * </pre>
       *
       * <code>.google.protobuf.Duration max_execution_period = 1 [json_name = "maxExecutionPeriod", (.gogoproto.nullable) = false, (.gogoproto.stdduration) = true, (.amino.dont_omitempty) = true];</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          com.google.protobuf.Duration, com.google.protobuf.Duration.Builder, com.google.protobuf.DurationOrBuilder> 
          getMaxExecutionPeriodFieldBuilder() {
        if (maxExecutionPeriodBuilder_ == null) {
          maxExecutionPeriodBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              com.google.protobuf.Duration, com.google.protobuf.Duration.Builder, com.google.protobuf.DurationOrBuilder>(
                  getMaxExecutionPeriod(),
                  getParentForChildren(),
                  isClean());
          maxExecutionPeriod_ = null;
        }
        return maxExecutionPeriodBuilder_;
      }

      private long maxMetadataLen_ ;
      /**
       * <pre>
       * max_metadata_len defines the max length of the metadata bytes field for various entities within the group module.
       * Defaults to 255 if not explicitly set.
       * </pre>
       *
       * <code>uint64 max_metadata_len = 2 [json_name = "maxMetadataLen"];</code>
       * @return The maxMetadataLen.
       */
      @java.lang.Override
      public long getMaxMetadataLen() {
        return maxMetadataLen_;
      }
      /**
       * <pre>
       * max_metadata_len defines the max length of the metadata bytes field for various entities within the group module.
       * Defaults to 255 if not explicitly set.
       * </pre>
       *
       * <code>uint64 max_metadata_len = 2 [json_name = "maxMetadataLen"];</code>
       * @param value The maxMetadataLen to set.
       * @return This builder for chaining.
       */
      public Builder setMaxMetadataLen(long value) {

        maxMetadataLen_ = value;
        bitField0_ |= 0x00000002;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * max_metadata_len defines the max length of the metadata bytes field for various entities within the group module.
       * Defaults to 255 if not explicitly set.
       * </pre>
       *
       * <code>uint64 max_metadata_len = 2 [json_name = "maxMetadataLen"];</code>
       * @return This builder for chaining.
       */
      public Builder clearMaxMetadataLen() {
        bitField0_ = (bitField0_ & ~0x00000002);
        maxMetadataLen_ = 0L;
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


      // @@protoc_insertion_point(builder_scope:cosmos.group.module.v1.Module)
    }

    // @@protoc_insertion_point(class_scope:cosmos.group.module.v1.Module)
    private static final com.cosmos.group.module.v1.ModuleProto.Module DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.cosmos.group.module.v1.ModuleProto.Module();
    }

    public static com.cosmos.group.module.v1.ModuleProto.Module getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Module>
        PARSER = new com.google.protobuf.AbstractParser<Module>() {
      @java.lang.Override
      public Module parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<Module> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Module> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.cosmos.group.module.v1.ModuleProto.Module getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cosmos_group_module_v1_Module_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cosmos_group_module_v1_Module_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n#cosmos/group/module/v1/module.proto\022\026c" +
      "osmos.group.module.v1\032 cosmos/app/v1alph" +
      "a1/module.proto\032\024gogoproto/gogo.proto\032\036g" +
      "oogle/protobuf/duration.proto\032\021amino/ami" +
      "no.proto\"\254\001\n\006Module\022Z\n\024max_execution_per" +
      "iod\030\001 \001(\0132\031.google.protobuf.DurationB\r\310\336" +
      "\037\000\230\337\037\001\250\347\260*\001R\022maxExecutionPeriod\022(\n\020max_m" +
      "etadata_len\030\002 \001(\004R\016maxMetadataLen:\034\272\300\226\332\001" +
      "\026\n\024cosmossdk.io/x/groupB\242\001\n\032com.cosmos.g" +
      "roup.module.v1B\013ModuleProto\242\002\003CGM\252\002\026Cosm" +
      "os.Group.Module.V1\312\002\026Cosmos\\Group\\Module" +
      "\\V1\342\002\"Cosmos\\Group\\Module\\V1\\GPBMetadata" +
      "\352\002\031Cosmos::Group::Module::V1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.cosmos.app.v1alpha1.ModuleProto.getDescriptor(),
          com.gogoproto.GogoProto.getDescriptor(),
          com.google.protobuf.DurationProto.getDescriptor(),
          com.amino.AminoProto.getDescriptor(),
        });
    internal_static_cosmos_group_module_v1_Module_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_cosmos_group_module_v1_Module_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cosmos_group_module_v1_Module_descriptor,
        new java.lang.String[] { "MaxExecutionPeriod", "MaxMetadataLen", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.amino.AminoProto.dontOmitempty);
    registry.add(com.cosmos.app.v1alpha1.ModuleProto.module);
    registry.add(com.gogoproto.GogoProto.nullable);
    registry.add(com.gogoproto.GogoProto.stdduration);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.cosmos.app.v1alpha1.ModuleProto.getDescriptor();
    com.gogoproto.GogoProto.getDescriptor();
    com.google.protobuf.DurationProto.getDescriptor();
    com.amino.AminoProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}