#include <cstdio>
#include <iostream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

struct report
{
    int Age ;
    int Malignancy ;
};

class Virus
{
    private:
        string name;
        int malignancy;
        int age;
        vector<report> ReportSitoGendeng ;
        string UniqueVirus[15] = {    // Start From Index 0
                                    "4L4Y",
                                    "B41K",
                                    "M4G3R",
                                    "LBHB41K",
                                    "ABA81L",
                                    "ABA81LV2", // 5
                                    "DARGOMBES",
                                    "DEWARUCI",
                                    "DOBBYTHEHOUSEELF",
                                    "DOBBY",
                                    "XXX", //10
                                    "YYY",
                                    "ZZZ"
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

        void reportEditing(int i, int _malignancy)
        {
            ReportSitoGendeng[i].Malignancy = _malignancy ;
        }

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

            else if(name == UniqueVirus[10]) // XXX
            {
                if(age%2 == 0)
                {
                    malignancy += 10 ;
                }
                else
                {
                    malignancy += 3 ;
                }

                if(malignancy > 99)
                {
                    malignancy = 99 ;
                }
                if(malignancy < 0)
                {
                    malignancy = 0 ;
                }
            }

            else if(name == UniqueVirus[11]) // YYY
            {
                malignancy += 5 ;

                if(malignancy > 99)
                {
                    malignancy = 99 ;
                }
                if(malignancy < 0)
                {
                    malignancy = 0 ;
                }   
            }

            else if(name == UniqueVirus[12]) // ZZZ
            {
                malignancy += 7 ;

                if(malignancy > 99)
                {
                    malignancy = 99 ;
                }
                if(malignancy < 0)
                {
                    malignancy = 0 ;
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
            
            ReportSitoGendeng.push_back({age,malignancy}); // SAVE REPORT
        
        };

        vector<Virus> Killing(vector<Virus> viruses)
        {
            if(name == "XXX")
            {
                for(int i=0; i<(int)viruses.size(); i++)
                {
                    if(viruses[i].Getname() == "ZZZ" and malignancy>viruses[i].GetMalignancy() and viruses[i].GetAge()>=300)
                    {
                        viruses[i].SetAge(200000000); // more than 365
                    }
                }
            }
            else if(name == "YYY")
            {
                for(int i=0; i<(int)viruses.size(); i++)
                {
                    if(viruses[i].Getname() == "XXX" and malignancy>viruses[i].GetMalignancy() and viruses[i].GetAge()>=200)
                    {
                        viruses[i].SetAge(200000000); // more than 365
                    }
                }
            }
            else if(name == "ZZZ")
            {
                for(int i=0; i<(int)viruses.size(); i++)
                {
                    if(viruses[i].Getname() == "YYY" and malignancy>viruses[i].GetMalignancy() and viruses[i].GetAge()>=100)
                    {
                        viruses[i].SetAge(200000000); // more than 365
                    }
                }
            };
            return viruses ;
        }

        void PrintReportSitoGendeng()
        {   
            cout << "Nama: "  << name << endl ; 
            for( int day=0 ; day< ReportSitoGendeng.size() ; day++ )
            {
                if(ReportSitoGendeng[day].Age < 365 or (name[0] == 'D' and name != UniqueVirus[8] and name != UniqueVirus[9]))
                {
                    cout << "Hari #"<< day+1 <<"; Usia: "<< ReportSitoGendeng[day].Age <<"; Tingkat Keganasan: " <<ReportSitoGendeng[day].Malignancy << endl ;
                }
                else
                {
                    cout << "Hari #" << day+1 <<"; Mati!!!" << endl;
                }
            }
        }

        void ReportPrint()
        {
            if(age < 365 or (name[0] == 'D' and name != UniqueVirus[8] and name != UniqueVirus[9]))
            {
                cout << "Nama: " << name << "; Usia: " << age << "; Tingkat Keganasan: " << malignancy << endl;                
            }
            else
            {
                cout << "Nama: "<< name << "; Mati!!!" << endl ;
            }
        };
};

int main()
{
    int numberOfVirus;
    int numberOfDay;
    int FlagReport;

    string virusName;
    int virusAge;
    int virusMalignancy;

    vector<Virus> viruses;

    cin >> numberOfVirus;
    cin >> numberOfDay;
    cin >> FlagReport;

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

    if(FlagReport == 1)
    {
        for( int day=1; day<=numberOfDay; day++ )
        {
            cout << "Hari #" << day << endl;
            for(int i=0; i<(int)viruses.size(); i++)
            {
                viruses[i].Update();
            }
            for(int i=0; i<(int)viruses.size(); i++)
            {
                viruses = viruses[i].Killing(viruses);
                viruses[i].ReportPrint();
            }
        }
    }
    else
    {
        for( int day=1; day<=numberOfDay; day++ )
        {
            for(int i=0; i<(int)viruses.size(); i++)
            {
                viruses[i].Update();
                viruses = viruses[i].Killing(viruses);
            }
        }
        for(int i=0; i<(int)viruses.size(); i++)
        {
            viruses[i].PrintReportSitoGendeng();
        }
    }

    return 0 ;
}