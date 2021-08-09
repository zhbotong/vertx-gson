package io.vertx.gson;
import io.vertx.core.spi.JsonFactory;
import io.vertx.core.spi.json.JsonCodec;

public class GsonFactory implements JsonFactory {

  public static final GsonFactory INSTANCE = new GsonFactory();

  public static final GsonCodec CODEC;

  static {
    CODEC = new GsonCodec();
  }

  @Override
  public JsonCodec codec() {
    return CODEC;
  }
}
