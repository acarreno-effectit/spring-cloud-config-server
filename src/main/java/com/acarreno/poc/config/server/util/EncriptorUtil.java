package com.acarreno.poc.config.server.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

@Component
public class EncriptorUtil {

  @Autowired
  private Environment env;

  public String decrypt(String value) {
    return textEncryptor().decrypt(value);
  }

  public String encrypt(String value) {
    return textEncryptor().encrypt(value);
  }

  public TextEncryptor textEncryptor() {
    return Encryptors.text(env.getProperty("encrypt.password"), env.getProperty("encrypt.key"));
  }

}
