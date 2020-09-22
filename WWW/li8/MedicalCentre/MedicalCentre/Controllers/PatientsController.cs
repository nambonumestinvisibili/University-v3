using MedicalCentre.Data;
using MedicalCentre.DTOs;
using MedicalCentre.Models;
using MedicalCentre.Profiles;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MedicalCentre.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class PatientsController : ControllerBase
    {

        private readonly IVisitsRepo _visits;
        private readonly IPatientsRepo _patients;
        private readonly IPatientsMapper _pMapper;
        private readonly IVisitsMapper _vMapper;

        //private readonly ILogger _logger;

        public PatientsController(IVisitsRepo visits, IPatientsRepo patients, IPatientsMapper pMapper, IVisitsMapper vMapper)
        {
            _visits = visits;
            _patients = patients;
            _pMapper = pMapper;
            _vMapper = vMapper;
        }

        //GET /api/patients
        [HttpGet(Name = "GetPatients")]
        public ActionResult<ICollection<PatientGeneralReadDTO>> GetPatients()
        {
            var pats = _patients.GetAllPatients();
            List<PatientGeneralReadDTO> result = new List<PatientGeneralReadDTO>();
            foreach (var each in pats) result.Add(_pMapper.ConvertPatientToGeneralReadDTO(each));
            return Ok(result);
        }

        //GET /api/patients/{id}
        [HttpGet("{id}")]
        public ActionResult<PatientDetailReadDTO> GetPatientById(int id)
        {
            var pat = _patients.GetPatientById(id);
            if (pat == null) return NotFound();
            return Ok(_pMapper.ConvertPatientToDetailReadDTO(pat));
        }

        [HttpGet("{id}/visits")]
        public ActionResult<ICollection<VisitGeneralReadDTO>> GetVisitsOfPatients(int id)
        {
            var visitsIndices = _patients.GetPatientById(id).VisitsId;
            var visColl = _visits.GetVisitsByPatient(visitsIndices);
            var visits = new List<VisitGeneralReadDTO>();
            foreach (var v in visColl) visits.Add(_vMapper.ConvertVisitToGeneralReadDTO(v));
            return visits;
        }

        [HttpPost]
        public ActionResult CreatePatient(PatientCreateDTO patient)
        {
            if (patient == null) return BadRequest();

            Patient pat = _pMapper.ConvertPatientCreateDTOToPatient(patient);
            _patients.CreateNewPatient(pat);
            return Ok();
        }
    }
}
