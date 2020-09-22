using MedicalCentre.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MedicalCentre.Data
{
    public class PatientsRepo : IPatientsRepo
    {

        private readonly List<Patient> _patients = new List<Patient>()
        {
            new Patient {Id=1, Name="Tony", Surname="Stark", Pesel=990314003210, VisitsId=new List<int>{1}},
            new Patient {Id=2, Name="Steve", Surname="Rogers", Pesel=990304003210, VisitsId=new List<int>{3,6,9,10}},
            new Patient {Id=3, Name="Wanda", Surname="Maximoff", Pesel=990324003210, VisitsId=new List<int>{2,4}},
            new Patient {Id=4, Name="Peter", Surname="Parker", Pesel=990334003210, VisitsId=new List<int>{5}},
            new Patient {Id=5, Name="Steven", Surname="Strange", Pesel=990344003210, VisitsId=new List<int>{7,8}},

        };

        public void CreateNewPatient(Patient patient)
        {
            if (patient == null) throw new ArgumentNullException();
            patient.Id = _patients.Count() + 1;
            _patients.Add(patient);
        }

        public ICollection<Patient> GetAllPatients()
        {
            return _patients;
        }

        public Patient GetPatientById(int id)
        {
            return _patients.Find(e => e.Id == id);
        }

        public bool SaveChanges()
        {
            throw new NotImplementedException();
        }

        public void UpdatePatient(int id)
        {
            throw new NotImplementedException();
        }
    }
}
