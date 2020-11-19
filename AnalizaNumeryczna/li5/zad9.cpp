#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

double rzad(double en1, double en2, double p){
    return abs(en1)/(pow(abs(en2), p));
}

int main(){
    double r_G[4] = {0.763907023, 0.543852762, 0.196247370, 0.009220859};
    double a_G[4] = {0.605426053, 0.055322784, 0.004819076, 0.000399783};

    for(int p=1; p<6; p++){
        cout<<"p= "<<p<<"   ";
        for(int i=1; i<4; i++){
            cout<<setprecision(12)<<rzad(r_G[i], r_G[i-1], p)<<"  |   ";
        }
        cout<<endl;
    }

    cout<<endl<<endl;

    for(int p=1; p<6; p++){
        cout<<"p= "<<p<<"   ";
        for(int i=1; i<4; i++){
            cout<<setprecision(12)<<rzad(a_G[i], a_G[i-1], p)<<"  |   ";
            cout<<"     ";
        }
        cout<<endl;
    }
    cout<<endl;
    cout<<"Rosjanie mają szybsza zbieżność (p=3). Amerykanie mają gorszą zbieśność (p=1)."<<endl;

    return 0;
}