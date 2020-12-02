using KursWWW.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace KursWWW.Data
{
    public class ParticipantsRepo : IParticipantsRepo
    {
        private readonly List<Person> participants = new List<Person>
        {
            new Person {FirstName="Adam", SecondName="Adamczak", City="Gdańsk", NumberOfPoints=10, Team=Teams.Ants},
            new Person {FirstName="Barbara", SecondName="Basińska", City="Borek", NumberOfPoints=20, Team=Teams.Beavers},
            new Person {FirstName="Eryk", SecondName="Cebula", City="Gdańsk", NumberOfPoints=30, Team=Teams.Ants},
            new Person {FirstName="Bartosz", SecondName="Karaszewski", City="Gdańsk", NumberOfPoints=10, Team=Teams.Ants},
            new Person {FirstName="Wojtek", SecondName="Rogacewicz", City="Wrocław", NumberOfPoints=0, Team=Teams.Beavers},
            new Person {FirstName="Marek", SecondName="Wilczyński", City="Wrocław", NumberOfPoints=14, Team=Teams.Beavers},
            new Person {FirstName="Wiktoria", SecondName="Bączek", City="Wrocław", NumberOfPoints=0, Team=Teams.Beavers},
            new Person {FirstName="Angelika", SecondName="Kostecka", City="Zielona Góra", NumberOfPoints=10, Team=Teams.Owls},
            new Person {FirstName="Klaudia", SecondName="Kostecka", City="Zielona Góra", NumberOfPoints=39, Team=Teams.Owls},
            new Person {FirstName="Katarzyna", SecondName="Leśniewska", City="Zielona Góra", NumberOfPoints=50, Team=Teams.Owls},
            new Person {FirstName="Katarzyna", SecondName="Gruszczyńska", City="Zielona Góra", NumberOfPoints=12, Team=Teams.Ants},
            new Person {FirstName="Waldemar", SecondName="Stępak", City="Zielona Góra", NumberOfPoints=0, Team=Teams.Ants},

        };

        public IEnumerable<Person> GetAllParticipants()
        {
            return participants;
        }
    }
}
