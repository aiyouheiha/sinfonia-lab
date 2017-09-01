# MD5 encryption with Java

- MD5 is a type of Message Digest, to represent the origin content.
- MD5 consists of 128 bits. Normally, 128 separate into 32 parts, every part has 4 bits.
- These 4 bits could be represented by one hex number (2^4 = 16).
- Then, the 32 length string is the digest after MD5 encryption..

## 1. make one util

```
public class MD5Util {
    public static String digest(byte[] input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance(Algorithm.MD5.name());
        return new BigInteger(1, md5.digest(input)).toString(16);
    }
}
```

## 2. using sample

```
@PostMapping("/md5")
public ResponseEntity<String> upload(@RequestBody MultipartFile multipartFile) 
        throws IOException, NoSuchAlgorithmException {
    return ResponseEntity.ok(MD5Util.digest(multipartFile.getBytes()));
}
```

- Send a post request with file content `123fsdfsdfds`.
- Then, result `5429dc25a3bacecdf0137d567a7a0d04` returned.