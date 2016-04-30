/*
 * Copyright 2013-2016 the original author or authors.
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

package org.cloudfoundry.reactor.uaa.identityzonemanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cloudfoundry.reactor.util.AbstractReactorOperations;
import org.cloudfoundry.reactor.util.AuthorizationProvider;
import org.cloudfoundry.uaa.identityzonemanagement.CreateIdentityZoneRequest;
import org.cloudfoundry.uaa.identityzonemanagement.CreateIdentityZoneResponse;
import org.cloudfoundry.uaa.identityzonemanagement.DeleteIdentityZoneRequest;
import org.cloudfoundry.uaa.identityzonemanagement.DeleteIdentityZoneResponse;
import org.cloudfoundry.uaa.identityzonemanagement.GetIdentityZoneRequest;
import org.cloudfoundry.uaa.identityzonemanagement.GetIdentityZoneResponse;
import org.cloudfoundry.uaa.identityzonemanagement.IdentityZoneManagement;
import org.cloudfoundry.uaa.identityzonemanagement.ListIdentityZoneRequest;
import org.cloudfoundry.uaa.identityzonemanagement.ListIdentityZoneResponse;
import org.cloudfoundry.uaa.identityzonemanagement.UpdateIdentityZoneRequest;
import org.cloudfoundry.uaa.identityzonemanagement.UpdateIdentityZoneResponse;
import reactor.core.publisher.Mono;
import reactor.io.netty.http.HttpClient;

import static org.cloudfoundry.util.tuple.TupleUtils.consumer;

/**
 * The Spring-based implementation of {@link IdentityZoneManagement}
 */
public final class SpringIdentityZoneManagement extends AbstractReactorOperations implements IdentityZoneManagement {

    /**
     * Creates an instance
     *
     * @param authorizationProvider the {@link AuthorizationProvider} to use when communicating with the server
     * @param httpClient            the {@link HttpClient} to use when communicating with the server
     * @param objectMapper          the {@link ObjectMapper} to use when communicating with the server
     * @param root                  the root URI of the server.  Typically something like {@code https://uaa.run.pivotal.io}.
     */
    public SpringIdentityZoneManagement(AuthorizationProvider authorizationProvider, HttpClient httpClient, ObjectMapper objectMapper, Mono<String> root) {
        super(authorizationProvider, httpClient, objectMapper, root);
    }

    @Override
    public Mono<CreateIdentityZoneResponse> create(CreateIdentityZoneRequest request) {
        return post(request, CreateIdentityZoneResponse.class, consumer((builder, validRequest) -> builder.pathSegment("identity-zones")));
    }

    @Override
    public Mono<DeleteIdentityZoneResponse> delete(DeleteIdentityZoneRequest request) {
        return delete(request, DeleteIdentityZoneResponse.class, consumer((builder, validRequest) -> builder.pathSegment("identity-zones", validRequest.getIdentityZoneId())));
    }

    @Override
    public Mono<GetIdentityZoneResponse> get(GetIdentityZoneRequest request) {
        return get(request, GetIdentityZoneResponse.class, consumer((builder, validRequest) -> builder.pathSegment("identity-zones", validRequest.getIdentityZoneId())));
    }

    @Override
    public Mono<ListIdentityZoneResponse> list(ListIdentityZoneRequest request) {
        return get(request, ListIdentityZoneResponse.class, consumer((builder, validRequest) -> builder.pathSegment("identity-zones")));
    }

    @Override
    public Mono<UpdateIdentityZoneResponse> update(UpdateIdentityZoneRequest request) {
        return put(request, UpdateIdentityZoneResponse.class, consumer((builder, validRequest) -> builder.pathSegment("identity-zones", validRequest.getIdentityZoneId())));
    }

}