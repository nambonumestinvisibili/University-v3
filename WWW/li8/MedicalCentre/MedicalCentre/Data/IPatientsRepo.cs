using MedicalCentre.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MedicalCentre.Data
{
    public interface IPatientsRepo
    {
        public bool SaveChanges();
        public ICollection<Patient> GetAllPatients();
        public Patient GetPatientById(int id);
        public void CreateNewPatient(Patient patient);
        public void UpdatePatient(int id);
    }
}
