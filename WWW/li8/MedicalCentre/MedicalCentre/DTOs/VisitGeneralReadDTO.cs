using MedicalCentre.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MedicalCentre.DTOs
{
    public class VisitGeneralReadDTO
    {
        public Link linkToSelf { get; set; }
        public int Id { get; set; }
        public string Date { get; set; }
    }
}
