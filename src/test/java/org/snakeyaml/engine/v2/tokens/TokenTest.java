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
package org.snakeyaml.engine.v2.tokens;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.exceptions.YamlEngineException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@org.junit.jupiter.api.Tag("fast")
class TokenTest {
    @Test
    void testToString() {
        Token token = new ScalarToken("a", true, Optional.empty(), Optional.empty());
        assertEquals("<scalar>", token.toString());
    }

    @Test
    void invalidDirectiveToken() {
        List<String> list = Collections.singletonList("key");
        YamlEngineException exception = assertThrows(YamlEngineException.class, () ->
                new DirectiveToken(DirectiveToken.YAML_DIRECTIVE, Optional.of(list), Optional.empty(), Optional.empty()));
        assertEquals("Two strings/integers must be provided instead of 1", exception.getMessage());
    }
}

