package io.vertx.gson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.DecodeException;
import io.vertx.core.json.EncodeException;
import io.vertx.core.spi.json.JsonCodec;

public class GsonCodec implements JsonCodec {

  private static Gson mapper = new Gson();
  private static Gson prettyMapper = new Gson();

  /**
   * Gson 序列化配置
   * @param builder
   */
  public static void config(GsonBuilder builder) {
    mapper = builder.create();
    prettyMapper = builder.setPrettyPrinting().create();
  }

  @Override
  public <T> T fromString(String json, Class<T> clazz) throws DecodeException {
    return GsonCodec.mapper.fromJson(json,clazz);
  }

  @Override
  public <T> T fromBuffer(Buffer json, Class<T> clazz) throws DecodeException {
    return GsonCodec.mapper.fromJson(json.toString(),clazz);
  }

  @Override
  public <T> T fromValue(Object json, Class<T> toValueType) {
    return null;
  }

  @Override
  public String toString(Object object, boolean pretty) throws EncodeException {

    if (pretty){
      return GsonCodec.prettyMapper.toJson(object);
    }
    return GsonCodec.mapper.toJson(object);
  }

  @Override
  public Buffer toBuffer(Object object, boolean pretty) throws EncodeException {
    if (pretty){
      return Buffer.buffer(GsonCodec.prettyMapper.toJson(object));
    }
    return Buffer.buffer(GsonCodec.mapper.toJson(object));
  }
}
