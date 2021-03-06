/*
 * Copyright 2013-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.client.v2.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.cloudfoundry.Nullable;
import org.cloudfoundry.client.v2.organizationquotadefinitions.OrganizationQuotaDefinitionResource;
import org.immutables.value.Value;

import java.util.List;

/**
 * The entity response payload for the User Organization resource
 */
@JsonDeserialize
@Value.Immutable
abstract class _UserOrganizationEntity {

    /**
     * Billing enabled
     */
    @JsonProperty("billing_enabled")
    @Nullable
    abstract Boolean getBillingEnabled();

    /**
     * The spaces
     */
    @JsonProperty("managers")
    @Nullable
    abstract List<UserResource> getManagers();

    /**
     * The name
     */
    @JsonProperty("name")
    @Nullable
    abstract String getName();

    /**
     * The quota definition id
     */
    @JsonProperty("quota_definition_guid")
    @Nullable
    abstract String getQuotaDefinitionId();

    /**
     * The spaces
     */
    @JsonProperty("quota_definition")
    @Nullable
    abstract List<OrganizationQuotaDefinitionResource> getQuotaDefinitions();

    /**
     * The spaces
     */
    @JsonProperty("spaces")
    @Nullable
    abstract List<UserSpaceResource> getSpaces();

    /**
     * The status
     */
    @JsonProperty("status")
    @Nullable
    abstract String getStatus();

}
