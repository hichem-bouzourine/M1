#include <iostream>

template <typename T>
class vector
{
private:
    T *Tab;

    size_t size;
    size_t alloc_size;

public:
    vector(size_t alloc_size = 0) : size(0), alloc_size(alloc_size)
    {
        if (alloc_size > 0)
        {
            Tab = new T[alloc_size];
        }
        else
        {
            Tab = nullptr;
        }
    };

    ~vector()
    {
        delete[] Tab;
        Tab = nullptr;
    };

    T &operator[](size_t index)
    {
        return Tab[index];
    }

    const T &operator[](size_t index) const
    {
        return Tab[index];
    }

    void push_back(const T &value)
    {
        if (size >= alloc_size)
        {
            size_t new_alloc_size = alloc_size * 2;
            T *new_Tab = new T[alloc_size];

            memcpy(new_Tab, Tab, sizeof(T) * size);

            delete[] Tab;
            Tab = new_Tab;
            alloc_size = new_alloc_size;
        }
        Tab[size] = value;
        size++;
    }

    size_t getSize() const
    {
        return size;
    }

    bool empty() const
    {
        if (size == 0)
            return false;
        else
            return true;
    }
};

template <typename iterator, typename T>
iterator find(iterator begin, iterator end, const T &target)
{
    while (begin != end)
    {
        if (*begin == target)
        {
            return begin;
        }
        begin++;
    }
    return end;
};

int main() {}