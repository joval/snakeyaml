/**
 * Copyright (c) 2018, http://www.snakeyaml.org
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.snakeyaml.engine.v2.common;

import java.util.Objects;

/**
 * Value inside Anchor and Alias
 */
public class Anchor {
    private final String value;

    public Anchor(String value) {
        Objects.requireNonNull(value, "Anchor must be provided.");
        if (value.isEmpty()) throw new IllegalArgumentException("Empty anchor.");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anchor anchor1 = (Anchor) o;
        return Objects.equals(value, anchor1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}