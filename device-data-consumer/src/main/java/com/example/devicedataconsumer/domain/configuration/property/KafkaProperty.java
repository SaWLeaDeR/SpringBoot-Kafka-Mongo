package com.example.devicedataconsumer.domain.configuration.property;

import javax.validation.constraints.NotNull;

public class KafkaProperty {

    @NotNull
    private String bootstrapServers;
    @NotNull
    private String groupId;
    @NotNull
    private String autoOffsetReset;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }
}
