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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("fast")
class AnchorTest {

    @Test
    @DisplayName("Anchor cannot be null")
    void testNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () ->
                new Anchor(null));
        assertEquals("Anchor must be provided.", exception.getMessage());
    }

    @Test
    @DisplayName("Anchor cannot be empty")
    void testEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Anchor(""));
        assertEquals("Empty anchor.", exception.getMessage());
    }
}
