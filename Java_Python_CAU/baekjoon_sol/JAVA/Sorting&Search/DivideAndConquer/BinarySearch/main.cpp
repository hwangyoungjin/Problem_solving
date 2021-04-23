#include <iostream>
using namespace std;

class A
{
private:
   int one;
public:
   A() : one(20)

   {
      cout << one << endl;
   }
   void member()
   {
      cout << "member" << endl;
   }
};

class B : public A
{
public:
   B() :A() {}
   void member()
   {
      cout << "member2" << endl;
   }
};

class C : public B
{
public: C():B(){}
     void member()
     {
        cout << "member3" << endl;
     }

};


int main()
{
   A a,*ab;
   ab = &a;
   ab->member();

   B b, *bc;
   bc = &b;
   bc->member();

   C c, *cd;
   cd = &c;
   cd->member();


   return 0;
}



