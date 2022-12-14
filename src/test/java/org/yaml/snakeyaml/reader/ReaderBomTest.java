/**
 * Copyright (c) 2008, SnakeYAML
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.yaml.snakeyaml.reader;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import junit.framework.TestCase;

public class ReaderBomTest extends TestCase {

  public void testReader() {
    Reader input = new StringReader("test");
    StreamReader reader = new StreamReader(input);
    assertEquals('t', reader.peek());
    reader.forward(1);
    assertEquals('e', reader.peek());
    reader.forward(1);
    assertEquals('s', reader.peek());
    reader.forward(1);
    assertEquals('t', reader.peek());
    reader.forward(1);
    assertEquals('\u0000', reader.peek());
  }

  public void testNoBom() throws IOException {
    byte[] data = "test".getBytes(StandardCharsets.UTF_8);
    ByteArrayInputStream input = new ByteArrayInputStream(data);
    UnicodeReader r = new UnicodeReader(input);
    StreamReader reader = new StreamReader(r);
    assertEquals('t', reader.peek());
    assertEquals(StandardCharsets.UTF_8, Charset.forName(r.getEncoding()));
    reader.forward(1);
    assertEquals('e', reader.peek());
    reader.forward(1);
    assertEquals('s', reader.peek());
    reader.forward(1);
    assertEquals('t', reader.peek());
    reader.forward(1);
    assertEquals('\u0000', reader.peek());
    r.close();
  }

  public void testUtf8Bom() throws IOException {
    File file = new File("src/test/resources/reader/utf-8.txt");
    assertTrue("Test file not found: " + file.getAbsolutePath(), file.exists());
    InputStream input = new FileInputStream(file);
    UnicodeReader unicodeReader = new UnicodeReader(input);
    StreamReader reader = new StreamReader(unicodeReader);
    assertEquals('t', reader.peek());
    reader.forward(1);
    assertEquals('e', reader.peek());
    reader.forward(1);
    assertEquals('s', reader.peek());
    reader.forward(1);
    assertEquals('t', reader.peek());
    reader.forward(1);
    assertEquals('\u0000', reader.peek());
    assertEquals(StandardCharsets.UTF_8, Charset.forName(unicodeReader.getEncoding()));
    input.close();
  }

  public void testUnicodeLeBom() throws IOException {
    File file = new File("src/test/resources/reader/unicode-16le.txt");
    assertTrue("Test file not found: " + file.getAbsolutePath(), file.exists());
    InputStream input = new FileInputStream(file);
    UnicodeReader unicodeReader = new UnicodeReader(input);
    StreamReader reader = new StreamReader(unicodeReader);
    assertEquals('t', reader.peek());
    reader.forward(1);
    assertEquals('e', reader.peek());
    reader.forward(1);
    assertEquals('s', reader.peek());
    reader.forward(1);
    assertEquals('t', reader.peek());
    reader.forward(1);
    assertEquals('\u0000', reader.peek());
    assertEquals(StandardCharsets.UTF_16LE, Charset.forName(unicodeReader.getEncoding()));
    input.close();
  }

  public void testUnicodeBeBom() throws IOException {
    File file = new File("src/test/resources/reader/unicode-16be.txt");
    assertTrue("Test file not found: " + file.getAbsolutePath(), file.exists());
    InputStream input = new FileInputStream(file);
    UnicodeReader unicodeReader = new UnicodeReader(input);
    StreamReader reader = new StreamReader(unicodeReader);
    assertEquals('t', reader.peek());
    reader.forward(1);
    assertEquals('e', reader.peek());
    reader.forward(1);
    assertEquals('s', reader.peek());
    reader.forward(1);
    assertEquals('t', reader.peek());
    reader.forward(1);
    assertEquals('\u0000', reader.peek());
    assertEquals(StandardCharsets.UTF_16BE, Charset.forName(unicodeReader.getEncoding()));
    input.close();
  }
}
