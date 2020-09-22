using MedicalCentre.DTOs;
using MedicalCentre.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MedicalCentre.Profiles
{
    public interface IVisitsMapper
    {
        public VisitGeneralReadDTO ConvertVisitToGeneralReadDTO(Visit visit);
        public VisitDetailReadDTO ConvertVisitToDetailReadDTO(Visit visit);
    }
}
