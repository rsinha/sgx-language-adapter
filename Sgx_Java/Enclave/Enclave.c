#include <string.h>
#include <sgx_cpuid.h>

#include "sgx_trts.h"
#include "Enclave.h"
#include "Enclave_t.h"

uint64_t ecall_decrypt(uint64_t pos, uint8_t enc_b, uint8_t *dec_b)
{
  *dec_b = enc_b ^ 0xFF;
  return 0;
}

uint64_t ecall_encrypt(uint64_t pos, uint8_t dec_b, uint8_t *enc_b)
{
  *enc_b = dec_b ^ 0xFF;
  return 0;
}
