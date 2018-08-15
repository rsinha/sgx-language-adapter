package LibSgxJava;

public class SgxFunction {
    static {
        System.loadLibrary("Sgx");
    }

    /* Initialize the enclave */
    public native int jni_initialize_enclave();

    /* decrypt FST byte in enclave */
    public native byte jni_ecall_decrypt(long pos, byte b);

    /* encrypt FST byte in enclave */
    public native byte jni_ecall_encrypt(long pos, byte b);

    /* Destroy the enclave */
    public native void jni_sgx_destroy_enclave();
}
