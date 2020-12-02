using KursWWW.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace KursWWW.Data
{
    public interface IParticipantsRepo
    {
        public IEnumerable<Person> GetAllParticipants();
    }
}
