package io.vertx.gson;

import io.vertx.core.json.Json;

public class Test {
  public static void main(String[] args) {
    String zhangsan = Json.encodePrettily(new User("zhangsan", "1234"));
    System.out.println(zhangsan);
  }
}
