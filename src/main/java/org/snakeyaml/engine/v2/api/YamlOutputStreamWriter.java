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
package org.snakeyaml.engine.v2.api;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * Provide an example of implementation of StreamDataWriter interface
 */
public abstract class YamlOutputStreamWriter extends OutputStreamWriter implements StreamDataWriter {
    public YamlOutputStreamWriter(OutputStream out, Charset cs) {
        super(out, cs);
    }

    public abstract void processIOException(IOException e);

    @Override
    public void flush() {
        try {
            super.flush();
        } catch (IOException e) {
            processIOException(e);
        }
    }

    @Override
    public void write(String str, int off, int len) {
        try {
            super.write(str, off, len);
        } catch (IOException e) {
            processIOException(e);
        }
    }

    @Override
    public void write(String str) {
        try {
            super.write(str);
        } catch (IOException e) {
            processIOException(e);
        }
    }
}
