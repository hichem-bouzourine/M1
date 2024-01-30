#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
int main()
{
pid_t pid ;
if ( (pid=fork())==0) {
printf ("Je suis le fils avec pid %d\n" , getpid ());
exit(0); }
else
if ( pid > 0) {
printf ("Je suis le pere avec pid %d\n" , getpid ());
printf (" J’attends que mon fils se termine\n" );
wait(NULL);
printf(" Fin de mon fils ...\n" );
}
else { printf ("Erreur dans la creation du fils\n" );
exit (2); }

}
