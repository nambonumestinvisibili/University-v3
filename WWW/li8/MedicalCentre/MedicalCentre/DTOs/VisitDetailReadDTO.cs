using MedicalCentre.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MedicalCentre.DTOs
{
    public class VisitDetailReadDTO
    {
        public int Id { get; set; }
        public string Date { get; set; }
        public bool IsPaid { get; set; }
        public long Prescription { get; set; }
        public Link Patient { get; set; }
        public ICollection<Link> Links { get; set; }
    }
}
