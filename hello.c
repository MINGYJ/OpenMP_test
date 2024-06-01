#include <stdio.h>
#include <omp.h>


int main(void)
{
    #pragma omp parallel
    {
    printf("Hello, world. HELLO SUMMER\n");
    printf("Hello, to all threads: %d.\n", omp_get_max_threads());
    }

  return 0;
}
