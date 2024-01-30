#pragma once
#include <iostream>
#include <atomic>
#include <mutex>

using namespace std;

namespace pr
{
    class Compte
    {
        int solde;
        mutable mutex mLock;

    public:
        Compte(int solde = 0) : solde(solde) {}
        Compte(const Compte &c)
        {
            c.mLock.lock();
            solde = c.solde;
            c.mLock.unlock();
        }
        // Question 7: il y a un probleme ici, le solde est une operation divisable, donc il faut un type atomic
        int getSolde() const
        {
            unique_lock<mutex> l(mLock);
            return solde;
        }
        void crediter(size_t val)
        {
            unique_lock<mutex> l(mLock);
            // mLock.lock();
            solde += val;
            // mLock.unlock();
        }
        bool debiter(unsigned int val)
        {
            unique_lock<mutex> l(mLock);
            // mLock.lock();
            bool doit = (solde >= val);
            if (doit)
            {
                solde -= val;
            }
            // mLock.unlock();
            return doit;
        }
    };
    const int JP = 10000;
    void jackpot(Compte &c)
    {
        for (int i = 0; i < JP; i++)
            c.crediter(1);
    };

    void losepot(Compte &c)
    {
        for (int i = 0; i < JP / 10; i++)
            c.debiter(10);
    }

}
