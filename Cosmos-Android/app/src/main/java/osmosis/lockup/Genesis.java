// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: osmosis/lockup/genesis.proto

package osmosis.lockup;

public final class Genesis {
  private Genesis() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface GenesisStateOrBuilder extends
      // @@protoc_insertion_point(interface_extends:osmosis.lockup.GenesisState)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
     */
    java.util.List<osmosis.lockup.Lock.PeriodLock> 
        getLocksList();
    /**
     * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
     */
    osmosis.lockup.Lock.PeriodLock getLocks(int index);
    /**
     * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
     */
    int getLocksCount();
    /**
     * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
     */
    java.util.List<? extends osmosis.lockup.Lock.PeriodLockOrBuilder> 
        getLocksOrBuilderList();
    /**
     * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
     */
    osmosis.lockup.Lock.PeriodLockOrBuilder getLocksOrBuilder(
        int index);
  }
  /**
   * <pre>
   * GenesisState defines the lockup module's genesis state.
   * </pre>
   *
   * Protobuf type {@code osmosis.lockup.GenesisState}
   */
  public  static final class GenesisState extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:osmosis.lockup.GenesisState)
      GenesisStateOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use GenesisState.newBuilder() to construct.
    private GenesisState(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private GenesisState() {
      locks_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new GenesisState();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private GenesisState(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
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
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                locks_ = new java.util.ArrayList<osmosis.lockup.Lock.PeriodLock>();
                mutable_bitField0_ |= 0x00000001;
              }
              locks_.add(
                  input.readMessage(osmosis.lockup.Lock.PeriodLock.parser(), extensionRegistry));
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
        if (((mutable_bitField0_ & 0x00000001) != 0)) {
          locks_ = java.util.Collections.unmodifiableList(locks_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return osmosis.lockup.Genesis.internal_static_osmosis_lockup_GenesisState_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return osmosis.lockup.Genesis.internal_static_osmosis_lockup_GenesisState_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              osmosis.lockup.Genesis.GenesisState.class, osmosis.lockup.Genesis.GenesisState.Builder.class);
    }

    public static final int LOCKS_FIELD_NUMBER = 1;
    private java.util.List<osmosis.lockup.Lock.PeriodLock> locks_;
    /**
     * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
     */
    public java.util.List<osmosis.lockup.Lock.PeriodLock> getLocksList() {
      return locks_;
    }
    /**
     * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
     */
    public java.util.List<? extends osmosis.lockup.Lock.PeriodLockOrBuilder> 
        getLocksOrBuilderList() {
      return locks_;
    }
    /**
     * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
     */
    public int getLocksCount() {
      return locks_.size();
    }
    /**
     * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
     */
    public osmosis.lockup.Lock.PeriodLock getLocks(int index) {
      return locks_.get(index);
    }
    /**
     * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
     */
    public osmosis.lockup.Lock.PeriodLockOrBuilder getLocksOrBuilder(
        int index) {
      return locks_.get(index);
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
      for (int i = 0; i < locks_.size(); i++) {
        output.writeMessage(1, locks_.get(i));
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < locks_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, locks_.get(i));
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
      if (!(obj instanceof osmosis.lockup.Genesis.GenesisState)) {
        return super.equals(obj);
      }
      osmosis.lockup.Genesis.GenesisState other = (osmosis.lockup.Genesis.GenesisState) obj;

      if (!getLocksList()
          .equals(other.getLocksList())) return false;
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
      if (getLocksCount() > 0) {
        hash = (37 * hash) + LOCKS_FIELD_NUMBER;
        hash = (53 * hash) + getLocksList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static osmosis.lockup.Genesis.GenesisState parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static osmosis.lockup.Genesis.GenesisState parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static osmosis.lockup.Genesis.GenesisState parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static osmosis.lockup.Genesis.GenesisState parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static osmosis.lockup.Genesis.GenesisState parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static osmosis.lockup.Genesis.GenesisState parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static osmosis.lockup.Genesis.GenesisState parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static osmosis.lockup.Genesis.GenesisState parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static osmosis.lockup.Genesis.GenesisState parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static osmosis.lockup.Genesis.GenesisState parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static osmosis.lockup.Genesis.GenesisState parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static osmosis.lockup.Genesis.GenesisState parseFrom(
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
    public static Builder newBuilder(osmosis.lockup.Genesis.GenesisState prototype) {
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
     * GenesisState defines the lockup module's genesis state.
     * </pre>
     *
     * Protobuf type {@code osmosis.lockup.GenesisState}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:osmosis.lockup.GenesisState)
        osmosis.lockup.Genesis.GenesisStateOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return osmosis.lockup.Genesis.internal_static_osmosis_lockup_GenesisState_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return osmosis.lockup.Genesis.internal_static_osmosis_lockup_GenesisState_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                osmosis.lockup.Genesis.GenesisState.class, osmosis.lockup.Genesis.GenesisState.Builder.class);
      }

      // Construct using osmosis.lockup.Genesis.GenesisState.newBuilder()
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
          getLocksFieldBuilder();
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (locksBuilder_ == null) {
          locks_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          locksBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return osmosis.lockup.Genesis.internal_static_osmosis_lockup_GenesisState_descriptor;
      }

      @java.lang.Override
      public osmosis.lockup.Genesis.GenesisState getDefaultInstanceForType() {
        return osmosis.lockup.Genesis.GenesisState.getDefaultInstance();
      }

      @java.lang.Override
      public osmosis.lockup.Genesis.GenesisState build() {
        osmosis.lockup.Genesis.GenesisState result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public osmosis.lockup.Genesis.GenesisState buildPartial() {
        osmosis.lockup.Genesis.GenesisState result = new osmosis.lockup.Genesis.GenesisState(this);
        int from_bitField0_ = bitField0_;
        if (locksBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            locks_ = java.util.Collections.unmodifiableList(locks_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.locks_ = locks_;
        } else {
          result.locks_ = locksBuilder_.build();
        }
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
        if (other instanceof osmosis.lockup.Genesis.GenesisState) {
          return mergeFrom((osmosis.lockup.Genesis.GenesisState)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(osmosis.lockup.Genesis.GenesisState other) {
        if (other == osmosis.lockup.Genesis.GenesisState.getDefaultInstance()) return this;
        if (locksBuilder_ == null) {
          if (!other.locks_.isEmpty()) {
            if (locks_.isEmpty()) {
              locks_ = other.locks_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureLocksIsMutable();
              locks_.addAll(other.locks_);
            }
            onChanged();
          }
        } else {
          if (!other.locks_.isEmpty()) {
            if (locksBuilder_.isEmpty()) {
              locksBuilder_.dispose();
              locksBuilder_ = null;
              locks_ = other.locks_;
              bitField0_ = (bitField0_ & ~0x00000001);
              locksBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getLocksFieldBuilder() : null;
            } else {
              locksBuilder_.addAllMessages(other.locks_);
            }
          }
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
        osmosis.lockup.Genesis.GenesisState parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (osmosis.lockup.Genesis.GenesisState) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<osmosis.lockup.Lock.PeriodLock> locks_ =
        java.util.Collections.emptyList();
      private void ensureLocksIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          locks_ = new java.util.ArrayList<osmosis.lockup.Lock.PeriodLock>(locks_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          osmosis.lockup.Lock.PeriodLock, osmosis.lockup.Lock.PeriodLock.Builder, osmosis.lockup.Lock.PeriodLockOrBuilder> locksBuilder_;

      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public java.util.List<osmosis.lockup.Lock.PeriodLock> getLocksList() {
        if (locksBuilder_ == null) {
          return java.util.Collections.unmodifiableList(locks_);
        } else {
          return locksBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public int getLocksCount() {
        if (locksBuilder_ == null) {
          return locks_.size();
        } else {
          return locksBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public osmosis.lockup.Lock.PeriodLock getLocks(int index) {
        if (locksBuilder_ == null) {
          return locks_.get(index);
        } else {
          return locksBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public Builder setLocks(
          int index, osmosis.lockup.Lock.PeriodLock value) {
        if (locksBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureLocksIsMutable();
          locks_.set(index, value);
          onChanged();
        } else {
          locksBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public Builder setLocks(
          int index, osmosis.lockup.Lock.PeriodLock.Builder builderForValue) {
        if (locksBuilder_ == null) {
          ensureLocksIsMutable();
          locks_.set(index, builderForValue.build());
          onChanged();
        } else {
          locksBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public Builder addLocks(osmosis.lockup.Lock.PeriodLock value) {
        if (locksBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureLocksIsMutable();
          locks_.add(value);
          onChanged();
        } else {
          locksBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public Builder addLocks(
          int index, osmosis.lockup.Lock.PeriodLock value) {
        if (locksBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureLocksIsMutable();
          locks_.add(index, value);
          onChanged();
        } else {
          locksBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public Builder addLocks(
          osmosis.lockup.Lock.PeriodLock.Builder builderForValue) {
        if (locksBuilder_ == null) {
          ensureLocksIsMutable();
          locks_.add(builderForValue.build());
          onChanged();
        } else {
          locksBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public Builder addLocks(
          int index, osmosis.lockup.Lock.PeriodLock.Builder builderForValue) {
        if (locksBuilder_ == null) {
          ensureLocksIsMutable();
          locks_.add(index, builderForValue.build());
          onChanged();
        } else {
          locksBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public Builder addAllLocks(
          java.lang.Iterable<? extends osmosis.lockup.Lock.PeriodLock> values) {
        if (locksBuilder_ == null) {
          ensureLocksIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, locks_);
          onChanged();
        } else {
          locksBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public Builder clearLocks() {
        if (locksBuilder_ == null) {
          locks_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          locksBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public Builder removeLocks(int index) {
        if (locksBuilder_ == null) {
          ensureLocksIsMutable();
          locks_.remove(index);
          onChanged();
        } else {
          locksBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public osmosis.lockup.Lock.PeriodLock.Builder getLocksBuilder(
          int index) {
        return getLocksFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public osmosis.lockup.Lock.PeriodLockOrBuilder getLocksOrBuilder(
          int index) {
        if (locksBuilder_ == null) {
          return locks_.get(index);  } else {
          return locksBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public java.util.List<? extends osmosis.lockup.Lock.PeriodLockOrBuilder> 
           getLocksOrBuilderList() {
        if (locksBuilder_ != null) {
          return locksBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(locks_);
        }
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public osmosis.lockup.Lock.PeriodLock.Builder addLocksBuilder() {
        return getLocksFieldBuilder().addBuilder(
            osmosis.lockup.Lock.PeriodLock.getDefaultInstance());
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public osmosis.lockup.Lock.PeriodLock.Builder addLocksBuilder(
          int index) {
        return getLocksFieldBuilder().addBuilder(
            index, osmosis.lockup.Lock.PeriodLock.getDefaultInstance());
      }
      /**
       * <code>repeated .osmosis.lockup.PeriodLock locks = 1;</code>
       */
      public java.util.List<osmosis.lockup.Lock.PeriodLock.Builder> 
           getLocksBuilderList() {
        return getLocksFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          osmosis.lockup.Lock.PeriodLock, osmosis.lockup.Lock.PeriodLock.Builder, osmosis.lockup.Lock.PeriodLockOrBuilder> 
          getLocksFieldBuilder() {
        if (locksBuilder_ == null) {
          locksBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              osmosis.lockup.Lock.PeriodLock, osmosis.lockup.Lock.PeriodLock.Builder, osmosis.lockup.Lock.PeriodLockOrBuilder>(
                  locks_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          locks_ = null;
        }
        return locksBuilder_;
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


      // @@protoc_insertion_point(builder_scope:osmosis.lockup.GenesisState)
    }

    // @@protoc_insertion_point(class_scope:osmosis.lockup.GenesisState)
    private static final osmosis.lockup.Genesis.GenesisState DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new osmosis.lockup.Genesis.GenesisState();
    }

    public static osmosis.lockup.Genesis.GenesisState getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<GenesisState>
        PARSER = new com.google.protobuf.AbstractParser<GenesisState>() {
      @java.lang.Override
      public GenesisState parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new GenesisState(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<GenesisState> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<GenesisState> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public osmosis.lockup.Genesis.GenesisState getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_osmosis_lockup_GenesisState_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_osmosis_lockup_GenesisState_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034osmosis/lockup/genesis.proto\022\016osmosis." +
      "lockup\032\031osmosis/lockup/lock.proto\"9\n\014Gen" +
      "esisState\022)\n\005locks\030\001 \003(\0132\032.osmosis.locku" +
      "p.PeriodLockB0Z.github.com/osmosis-labs/" +
      "osmosis/x/lockup/typesb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          osmosis.lockup.Lock.getDescriptor(),
        });
    internal_static_osmosis_lockup_GenesisState_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_osmosis_lockup_GenesisState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_osmosis_lockup_GenesisState_descriptor,
        new java.lang.String[] { "Locks", });
    osmosis.lockup.Lock.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
