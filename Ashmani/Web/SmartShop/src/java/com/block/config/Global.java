package com.block.config;

public interface Global {
    
    String CONTEXT = "F:/STUDY/BE/Semester_VIII/MajorProject/Implementation/Web/SmartShop/";
            
    String BARCODE_PATH = CONTEXT+"web/barcode/";
    
    String SERIALIZED_DEFAULT_FILE_PATH = CONTEXT+"web/serialize/";

    String BLOCK_FILE_NAME = "blockchain.ser";

    String WALLET_FILE_NAME = "wallet.ser";

    String DEFAULT_KEY_GEN_ALGORITHM = "ECDSA";

    String DEFAULT_SEC_PROVIDER = "BC";

    String DEFAULT_PSEUDO_RANDOM_GEN_ALGO = "SHA1PRNG";

    String DEFAULT_NAMED_CURVE = "prime192v1";

    String DEFAULT_HASH_GEN_ALGO = "SHA-256";

    String DEFAULT_ENCODING_SCHEME = "UTF-8";

    double TOTAL_COINBASE = 1000;
}
