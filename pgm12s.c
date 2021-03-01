//Public:A prime number p,q such that q divides (p - 1).
//g = h^(p - 1)/q mod p,  1<h<(p - 1) and g >1.
//private key:x must be a number greater than 1 to q-1 chosen randomly
//public key;y=g^xmod p 
//M: Message
//h: hash value entered by user
//H=H(M)
//signature(H,k)
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
int powermod(int h,int power,int p)
{
  int i=1,res=1;
  for(i=1;i<=power;i++)
  {
    res=res*h;
    res=res%p;
  }
  return res;
}
int HF(int M,int hash)
{
  return hash^M;
}
extendedeuclid(int n,int num)
{
  int rem=1,p[10],i=0,q[10];
  while(rem!=0)
  {
    q[i]=n/num;
    rem=n%num;
    n=num;
    num=rem;
    if(i==0)
    {
       p[i]=0;
    }   
    else if(i==1)
       p[i]=1;
    else p[i]=p[i-2]-(q[i-2])*p[i-1];
    i++;  
  }
  p[++i]=p[i-2]-(q[i-2])*p[i-1];
  return p[i];
}
int main()
{
  int p,q,hash,x,k,g,M,H,y,kinv,s,r,h;
  srand(time(NULL));
  printf("Enter the values of M,p,q,hash: ");scanf("%d%d%d%d",&M,&p,&q,&hash);
  while((h=rand()%(p-1))<=1);
  g=powermod(h,(p-1)/q,p);
  while((x=rand()%q)<0);//private key
  while((k=rand()%q)<0);

  H=HF(M,hash);
   printf("h=%d,g=%d,x=%d,k=%d\n",h,g,x,k);
  y=powermod(g,x,p);//public key
  r=powermod(g,k,p)%q;
  kinv=extendedeuclid(q,k);
  printf("Public key: x=%d,Private key: y=%d\n",x,y);
  s=(kinv*(h+(x*r)))%q;
  printf("Signature(s,r): \n",s,r);
  return 0;
}
