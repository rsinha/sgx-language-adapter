import LibSgxJava.*;

class JavaApp {
    public static void main(String args[]){
 
        SgxFunction sgxFunctionTest = new SgxFunction();
        
        /*Initialize enclave */
        int initEnclaveStat = -1;
        initEnclaveStat = sgxFunctionTest.jni_initialize_enclave();
        if (initEnclaveStat < 0) {
            System.out.print("Failed to initiate enclave! Exiting...");
            return;
        }
        System.out.println("Successfully initialized enclave!");

        /*Calling the sgx function */
        byte ciphertext = sgxFunctionTest.jni_ecall_encrypt(0L, (byte) 0x05);
	byte plaintext = sgxFunctionTest.jni_ecall_decrypt(0L, ciphertext);
	
	System.out.println("ciphertext: " + Integer.toHexString(ciphertext & 0xFF));
	System.out.println("plaintext: " + Integer.toHexString(plaintext & 0xFF));

        /*Destroy the enclave */
        sgxFunctionTest.jni_sgx_destroy_enclave();
    }
}





        






