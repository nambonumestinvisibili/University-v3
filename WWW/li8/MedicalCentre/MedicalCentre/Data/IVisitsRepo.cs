using MedicalCentre.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MedicalCentre.Data
{
    public interface IVisitsRepo
    {
        public ICollection<Visit> GetAllVisits();
        public Visit GetVisitById(int id);
        public ICollection<Visit> GetVisitsByPatient(ICollection<int> visitIndices);

    }
}
