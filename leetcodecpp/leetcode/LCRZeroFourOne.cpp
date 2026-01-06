#include "queue"

using namespace std;

class MovingAverage {
public:
    /** Initialize your data structure here. */
    MovingAverage(int size) {
        this->size = size;
        this->mean = 0.0;
        this->windowSum = 0.0;
    }

    double next(int val) {
        queue.push(val);
        this->windowSum += val;

        if (this->queue.size() > this->size) {
            int top = queue.front();
            queue.pop();
            this->windowSum -= top;

        }
        return this->windowSum / queue.size();
    }

private:
    int size;
    double mean;
    double windowSum;
    queue<int> queue;
};

