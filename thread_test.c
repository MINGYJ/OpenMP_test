#include <stdio.h>
#include <omp.h>


int main (int argc, char *argv[]) {

  int th_id, nthreads;
  int share_v1[24577], share_v2=0, priv_v1, priv_v2;
  
  
#pragma omp parallel shared(share_v1,share_v2) private(priv_v1,priv_v2)

  //th_id is declared above.  It is is specified as private; so each
  //thread will have its own copy of th_id
  {
    th_id = omp_get_thread_num();
    share_v1[th_id] = share_v2;
    share_v2+=1;
    printf("Hello World from thread %d\n", th_id);
  }

  for (int i = 0; i < share_v2 ; i++){
    printf("share_v1[%d] = %d\n", i, share_v1[i]);
  }


}//end of main