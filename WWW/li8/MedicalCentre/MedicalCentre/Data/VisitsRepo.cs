using MedicalCentre.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MedicalCentre.Data
{
    public class VisitsRepo : IVisitsRepo
    {
        private readonly PatientsRepo _patients; 

        private readonly List<Visit> _visits = new List<Visit>(){
            new Visit {Id=1, Date="28.03", IsPaid=true,  Prescription=14569, PatientId = 1},
            new Visit {Id=2, Date="30.03", IsPaid=true,  Prescription=14570, PatientId = 3},
            new Visit {Id=3, Date="20.04", IsPaid=false, Prescription=14571, PatientId = 2},
            new Visit {Id=4, Date="08.04", IsPaid=false, Prescription=14572, PatientId = 3},
            new Visit {Id=5, Date="09.04", IsPaid=true,  Prescription=14573, PatientId = 4},
            new Visit {Id=6, Date="14.05", IsPaid=true,  Prescription=14574, PatientId = 2},
            new Visit {Id=7, Date="19.05", IsPaid=false, Prescription=14575, PatientId = 5},
            new Visit {Id=8, Date="30.06", IsPaid=true,  Prescription=14576, PatientId = 5},
            new Visit {Id=9, Date="01.07", IsPaid=true,  Prescription=14577, PatientId = 2},
            new Visit {Id=10, Date="28.08", IsPaid=false,Prescription=14578, PatientId = 2},
        };

        public ICollection<Visit> GetAllVisits()
        {
            return _visits;
        }

        public Visit GetVisitById(int id)
        {
            return _visits.Find(v => v.Id == id);
        }

        public ICollection<Visit> GetVisitsByPatient(ICollection<int> visitIndices)
        {
            List<Visit> visits = new List<Visit>();
            foreach (int i in visitIndices){
                Visit v = _visits.Find(x => x.Id == i);
                if (v != null) visits.Add(v);
            }
            return visits;
        }
    }
}
