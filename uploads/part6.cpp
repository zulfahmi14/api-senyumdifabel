#include <cstdio>
#include <iostream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

class Virus
{
    private:
        string name;
        int malignancy;
        int age;
        string UniqueVirus[10] = {    // Start From Index 0
                                    "4L4Y",
                                    "B41K",
                                    "M4G3R",
                                    "LBHB41K",
                                    "ABA81L",
                                    "ABA81LV2",
                                    "DARGOMBES",
                                    "DEWARUCI",
                                    "DOBBYTHEHOUSEELF",
                                    "DOBBY"
                                };

    public:

        // Constructor
        Virus()
        {
        };

        Virus( string name, int malignancy, int age )
        {
            name = name ;
            malignancy = malignancy ;
            age = age ;
        };

        // Setter and Getter
        void SetName(string _name)
        {
            name = _name;
        };

        void SetMalignancy(int _malignancy)
        {
            malignancy = _malignancy;
        };

        void SetAge(int _age)
        {
            age = _age;
        };

        string Getname()
        {
            return name ;
        };

        int GetMalignancy()
        {
            return malignancy ;
        };

        int GetAge()
        {
            return age ;
        };

        // Method
        void Update()
        {
            age++;

            if( name == UniqueVirus[0] ) //"4L4Y"
            {
                malignancy += 2;

                if(malignancy < 0)
                {
                    malignancy = 0;
                }
                if(malignancy > 99)
                {
                    malignancy = 99;
                }
            }

            else if( name == UniqueVirus[1] ) //"B41K",
            {
                if(age%100 == 0)
                {
                    malignancy++;
                }

                if(malignancy < 0)
                {
                    malignancy = 0;
                }
                if(malignancy > 99)
                {
                    malignancy = 99;
                }
            }

            else if( name == UniqueVirus[2] ) //"M4G3R"
            {
            }

            else if( name == UniqueVirus[3] ) //"LBHB41K"
            {
                if(age%5 == 0)
                {
                    malignancy--;
                }

                if(malignancy < 0)
                {
                    malignancy = 0;
                }
                if(malignancy > 99)
                {
                    malignancy = 99;
                }
            }

            else if(name == UniqueVirus[4] ) //"ABA81L"
            {
                if(age < 100)
                {
                    if(age%4 == 0)
                    {
                        malignancy += 7;
                    }
                    if(malignancy > 99)
                    {
                        malignancy = 99;
                    }
                }
                else if(age>= 100 and age <=109)
                {

                }
                else
                {
                    if(age%10 == 0)
                    {
                        malignancy = round( malignancy/2 ) ; // Integer pembulatan kebawah
                    }
                    if(malignancy < 0)
                    {
                        malignancy = 0;
                    }
                }
            }

            else if(name == UniqueVirus[5] ) //"ABA81LV2"
            {
                malignancy++ ;

                if(age < 100)
                {
                    if(age%4 == 0)
                    {
                        malignancy += 7;
                    }
                    if(malignancy > 99)
                    {
                        malignancy = 99;
                    }
                }
                else if(age>= 100 and age <=109)
                {
                    if(malignancy > 99)
                    {
                        malignancy = 99;
                    }
                }
                else
                {
                    if(age%10 == 0)
                    {
                        malignancy = round( malignancy/2 ) ; // Integer pembulatan kebawah
                    }
                    if(malignancy < 0)
                    {
                        malignancy = 0;
                    }
                }
            }

            else if(name == UniqueVirus[6]) //"DARGOMBES"
            {
                malignancy += 3 ;
                if(malignancy > 9999)
                {
                    malignancy = 9999;
                }
                if(malignancy <0)
                {
                    malignancy = 0 ;
                }
            }

            else if(name == UniqueVirus[7]) // "DEWARUCI"
            {
                if(age%2 == 0)
                {
                    malignancy -= 5 ;   
                }
                if(malignancy < -9999)
                {
                    malignancy = -9999 ;
                }
                if(malignancy >0 )
                {
                    malignancy = 0 ;
                }
            }

            else if(name == UniqueVirus[8] or name == UniqueVirus[9]) //"DOBBYTHEHOUSEELF"
            {
                if(malignancy < -666)
                {
                    malignancy = -666 ;
                }
                else if(malignancy > 666)
                {
                    malignancy = 666 ;
                }
                if(malignancy > 0)
                {
                    if(malignancy > 300 and age >= 200)
                    {
                        malignancy -= 15 ;
                    }
                    else if(age >= 300)
                    {
                        malignancy = malignancy/2 ;
                    }
                    else
                    {
                        malignancy -= 3 ;
                    }
                }
                else
                {
                    if( age >= 110 and malignancy < -600)
                    {
                        malignancy = malignancy/2 ;
                    }
                    else if( age >= 100 and malignancy < -600)
                    {
                        malignancy += 15 ;
                    }
                    else if( age >= 100 and malignancy < 0)
                    {
                        malignancy += 7 ;
                    }
                    else
                    {
                        malignancy += 2 ;
                    }
                }
            }

            else //LebayEffect
            {
                if(age >= 200)
                {
                    if(age%5 == 0)
                    {
                        malignancy += 2;
                    }

                    if(malignancy < 0)
                    {
                        malignancy = 0;
                    }
                    if(malignancy > 99)
                    {
                        malignancy = 99;
                    }
                }
                else
                {
                    if(age%3 == 0)
                    {
                        malignancy++;
                    }

                    if(malignancy < 0)
                    {
                        malignancy = 0;
                    }
                    if(malignancy > 99)
                    {
                        malignancy = 99;
                    }
                }
            };

        };

        void ReportPrint()
        {
            if(age < 365 or (name[0] == 'D' and name != UniqueVirus[8] and name != UniqueVirus[9]))
            cout << "Nama: " << name << "; Usia: " << age << "; Tingkat Keganasan: " << malignancy << endl;
        };
};

int main()
{
    int numberOfVirus;
    int numberOfDay;

    string virusName;
    int virusAge;
    int virusMalignancy;

    vector<Virus> viruses;

    cin >> numberOfVirus;
    cin >> numberOfDay;

    for( int i=0; i<numberOfVirus; i++ )
    {
        cin >> virusName ;
        cin >> virusAge ;
        cin >> virusMalignancy ;

        Virus virus ;
        virus.SetName(virusName);
        virus.SetAge(virusAge);
        virus.SetMalignancy(virusMalignancy);

        viruses.push_back(virus);
    }

    for( int day=1; day<=numberOfDay; day++ )
    {
        cout << "Hari #" << day << endl;
        for(int i=0; i<(int)viruses.size(); i++)
        {
            viruses[i].Update();
            viruses[i].ReportPrint();
        }
    }

    return 0 ;
}