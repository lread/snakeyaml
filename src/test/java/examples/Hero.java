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
package examples;

public class Hero {

  private final String name;
  private final Integer sp;
  private final Integer hp;

  public Hero(String name, Integer hp, Integer sp) {
    super();
    this.name = name;
    this.sp = sp;
    this.hp = hp;
  }

  public String getName() {
    return name;
  }

  public Integer getSp() {
    return sp;
  }

  public Integer getHp() {
    return hp;
  }

}
