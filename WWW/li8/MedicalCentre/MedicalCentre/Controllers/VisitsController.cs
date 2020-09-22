using MedicalCentre.Data;
using MedicalCentre.DTOs;
using MedicalCentre.Models;
using MedicalCentre.Profiles;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;

namespace MedicalCentre.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class VisitsController : ControllerBase
    {
        private readonly IVisitsRepo _visits;
        private readonly IPatientsRepo _patients;
        private readonly IVisitsMapper _vmapper;

        public VisitsController(IVisitsRepo visits, IPatientsRepo patients, IVisitsMapper vmapper)
        {
            _visits = visits;
            _patients = patients;
            _vmapper = vmapper;
        }

        //GET /api/visits
        [HttpGet]
        public ActionResult<ICollection<Visit>> GetVisits()
        {
            var vits = _visits.GetAllVisits();
            List<VisitGeneralReadDTO> result = new List<VisitGeneralReadDTO>();
            foreach (var each in vits) result.Add(_vmapper.ConvertVisitToGeneralReadDTO(each));
            return Ok(result);
        }

        //GET /api/visits/{id}
        [HttpGet("{id}")]
        public ActionResult<Patient> GetVisitById(int id)
        {
            var vit = _visits.GetVisitById(id);
            if (vit == null) return NotFound();
            return Ok(_vmapper.ConvertVisitToDetailReadDTO(vit));
        }

        //TODO!
        //GET /api/visits/{id}/status
        [HttpGet("{id}/status")]
        public ActionResult<JsonResult> GetVisitStatus(int id)
        {
            var vit = _visits.GetVisitById(id);
            if (vit == null) return NotFound();
            return Ok(vit.IsPaid);
            //var odp = new JsonResult(new { isPaid = vit.IsPaid });
            //return Ok(odp);
        }
    }
}
