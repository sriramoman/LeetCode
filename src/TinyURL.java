class Codec {

    // Encodes data URL to data shortened URL.
    public String encode(String longUrl) {
        return longUrl;
    }

    // Decodes data shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortUrl;
    }
}

public class TinyURL {
    public static void main(String[] args){
        Codec codec = new Codec();
        System.out.print(codec.decode(codec.encode("http://sriramoman.com")));
    }
}
