using MedicalCentre.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MedicalCentre.DTOs
{
    public class PatientDetailReadDTO
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Surname { get; set; }
        public long Pesel { get; set; }
        public Link Visits { get; set; }
        public ICollection<Link> Links { get; set; }

    }
}
