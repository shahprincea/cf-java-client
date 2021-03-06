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

package org.cloudfoundry.operations.serviceadmin;

import org.cloudfoundry.Nullable;
import org.immutables.value.Value;

import java.util.List;

/**
 * A Service Access
 */
@Value.Immutable
abstract class _ServiceAccess {

    /**
     * The access
     */
    abstract Access getAccess();

    /**
     * The broker name
     */
    abstract String getBrokerName();

    /**
     * The organizations
     */
    @Nullable
    abstract List<String> getOrganizationNames();

    /**
     * The plan name
     */
    abstract String getPlanName();

    /**
     * The service name
     */
    abstract String getServiceName();

}
