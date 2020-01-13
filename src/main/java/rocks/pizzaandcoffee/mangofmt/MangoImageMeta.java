package rocks.pizzaandcoffee.mangofmt;

import com.sun.jna.ptr.IntByReference;

import java.util.Base64;

public class MangoImageMeta {

    IntByReference pointer;

    MangoImageMeta(IntByReference pointer) {
        this.pointer = pointer;
    }


    public String getCompression() {
        return LibMango.INSTANCE.mangoimgmeta_compression(this.pointer);
    }

    public String getEncryption() {
        return LibMango.INSTANCE.mangoimgmeta_encryption(this.pointer);
    }

    public String getChecksum() {
        return LibMango.INSTANCE.mangoimgmeta_checksum(this.pointer);
    }

    public String getMime() {
        return LibMango.INSTANCE.mangoimgmeta_mime(this.pointer);
    } 

    public String getFilename() {
        return LibMango.INSTANCE.mangoimgmeta_filename(this.pointer);
    } 

    public int[] getIv() {
        return LibMango.INSTANCE.mangoimgmeta_iv(this.pointer);
    } 
    
    public int getIvSize() {
        return LibMango.INSTANCE.mangoimgmeta_iv_size(this.pointer);
    } 
}

