using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace KursWWW.Models
{
    public class Person
    {
        //liczbę punktów, imię, nazwisko, miasto, nazwę drużyny
        public string FirstName { get; set; }
        public string SecondName { get; set; }
        public string City { get; set; }
        public Teams Team { get; set; }
        public int NumberOfPoints { get; set; }
    }
}
