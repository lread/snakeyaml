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
package org.yaml.snakeyaml.nodes;

import junit.framework.TestCase;
import org.yaml.snakeyaml.DumperOptions;

public class MappingNodeTest extends TestCase {

  public void testNullValue() {
    try {
      new MappingNode(new Tag("!tag"), true, null, null, null, DumperOptions.FlowStyle.BLOCK);
      fail("Value is required.");
    } catch (Exception e) {
      assertEquals("value in a Node is required.", e.getMessage());
    }
  }
}
