/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.commons.validation;

/**
 * Helper class for parameters validation, such as not null arguments.
 */
public final class Preconditions extends PortablePreconditions {

    /**
     * Should not be instantiated
     */
    protected Preconditions() {
        super();
    }

    public static <T> T checkInstanceOf(final String name,
                                        Object parameter,
                                        final Class<T> clazz) {
        checkNotNull(name,
                     parameter);
        checkNotNull("clazz",
                     clazz);
        if (!clazz.isInstance(parameter)) {
            throw new IllegalArgumentException("Parameter named '" + name + "' is not instance of clazz '" + clazz.getName() + "'!");
        }

        return clazz.cast(parameter);
    }
}
