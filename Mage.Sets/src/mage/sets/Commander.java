/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

package mage.sets;

import mage.constants.SetType;
import mage.cards.ExpansionSet;
import mage.constants.Rarity;
import mage.cards.CardGraphicInfo;

/**
 *
 * @author LevelX2
 */

public class Commander extends ExpansionSet {

    private static final Commander fINSTANCE = new Commander();

    public static Commander getInstance() {
        return fINSTANCE;
    }

    private Commander() {
        super("Commander", "CMD", ExpansionSet.buildDate(2011, 6, 17), SetType.SUPPLEMENTAL);
        this.blockName = "Command Zone";
        cards.add(new SetCardInfo("Acidic Slime", 140, Rarity.UNCOMMON, mage.cards.a.AcidicSlime.class));
        cards.add(new SetCardInfo("Acorn Catapult", 241, Rarity.RARE, mage.cards.a.AcornCatapult.class));
        cards.add(new SetCardInfo("Aethersnipe", 39, Rarity.COMMON, mage.cards.a.Aethersnipe.class));
        cards.add(new SetCardInfo("Afterlife", 2, Rarity.UNCOMMON, mage.cards.a.Afterlife.class));
        cards.add(new SetCardInfo("Akoum Refuge", 264, Rarity.UNCOMMON, mage.cards.a.AkoumRefuge.class));
        cards.add(new SetCardInfo("Akroma, Angel of Fury", 108, Rarity.RARE, mage.cards.a.AkromaAngelOfFury.class));
        cards.add(new SetCardInfo("Akroma's Vengeance", 3, Rarity.RARE, mage.cards.a.AkromasVengeance.class));
        cards.add(new SetCardInfo("Alliance of Arms", 4, Rarity.RARE, mage.cards.a.AllianceOfArms.class));
        cards.add(new SetCardInfo("Angelic Arbiter", 5, Rarity.RARE, mage.cards.a.AngelicArbiter.class));
        cards.add(new SetCardInfo("Angel of Despair", 180, Rarity.RARE, mage.cards.a.AngelOfDespair.class));
        cards.add(new SetCardInfo("Anger", 109, Rarity.UNCOMMON, mage.cards.a.Anger.class));
        cards.add(new SetCardInfo("Animar, Soul of Elements", 181, Rarity.MYTHIC, mage.cards.a.AnimarSoulOfElements.class));
        cards.add(new SetCardInfo("Aquastrand Spider", 141, Rarity.COMMON, mage.cards.a.AquastrandSpider.class));
        cards.add(new SetCardInfo("Arbiter of Knollridge", 6, Rarity.RARE, mage.cards.a.ArbiterOfKnollridge.class));
        cards.add(new SetCardInfo("Archangel of Strife", 7, Rarity.RARE, mage.cards.a.ArchangelOfStrife.class));
        cards.add(new SetCardInfo("Armillary Sphere", 242, Rarity.COMMON, mage.cards.a.ArmillarySphere.class));
        cards.add(new SetCardInfo("Artisan of Kozilek", 1, Rarity.UNCOMMON, mage.cards.a.ArtisanOfKozilek.class));
        cards.add(new SetCardInfo("Attrition", 72, Rarity.RARE, mage.cards.a.Attrition.class));
        cards.add(new SetCardInfo("Aura Shards", 182, Rarity.UNCOMMON, mage.cards.a.AuraShards.class));
        cards.add(new SetCardInfo("Austere Command", 8, Rarity.RARE, mage.cards.a.AustereCommand.class));
        cards.add(new SetCardInfo("Avatar of Fury", 110, Rarity.RARE, mage.cards.a.AvatarOfFury.class));
        cards.add(new SetCardInfo("Avatar of Slaughter", 111, Rarity.RARE, mage.cards.a.AvatarOfSlaughter.class));
        cards.add(new SetCardInfo("Avatar of Woe", 73, Rarity.RARE, mage.cards.a.AvatarOfWoe.class));
        cards.add(new SetCardInfo("Awakening Zone", 142, Rarity.RARE, mage.cards.a.AwakeningZone.class));
        cards.add(new SetCardInfo("Azorius Chancery", 265, Rarity.COMMON, mage.cards.a.AzoriusChancery.class));
        cards.add(new SetCardInfo("Azorius Guildmage", 183, Rarity.UNCOMMON, mage.cards.a.AzoriusGuildmage.class));
        cards.add(new SetCardInfo("Baloth Woodcrasher", 143, Rarity.UNCOMMON, mage.cards.b.BalothWoodcrasher.class));
        cards.add(new SetCardInfo("Barren Moor", 266, Rarity.COMMON, mage.cards.b.BarrenMoor.class));
        cards.add(new SetCardInfo("Basandra, Battle Seraph", 184, Rarity.RARE, mage.cards.b.BasandraBattleSeraph.class));
        cards.add(new SetCardInfo("Bathe in Light", 9, Rarity.UNCOMMON, mage.cards.b.BatheInLight.class));
        cards.add(new SetCardInfo("Bestial Menace", 144, Rarity.UNCOMMON, mage.cards.b.BestialMenace.class));
        cards.add(new SetCardInfo("Bladewing the Risen", 185, Rarity.RARE, mage.cards.b.BladewingTheRisen.class));
        cards.add(new SetCardInfo("Bojuka Bog", 267, Rarity.COMMON, mage.cards.b.BojukaBog.class));
        cards.add(new SetCardInfo("Boros Garrison", 268, Rarity.COMMON, mage.cards.b.BorosGarrison.class));
        cards.add(new SetCardInfo("Boros Guildmage", 186, Rarity.UNCOMMON, mage.cards.b.BorosGuildmage.class));
        cards.add(new SetCardInfo("Boros Signet", 243, Rarity.COMMON, mage.cards.b.BorosSignet.class));
        cards.add(new SetCardInfo("Brainstorm", 40, Rarity.COMMON, mage.cards.b.Brainstorm.class));
        cards.add(new SetCardInfo("Brawn", 145, Rarity.UNCOMMON, mage.cards.b.Brawn.class));
        cards.add(new SetCardInfo("Breath of Darigaaz", 112, Rarity.UNCOMMON, mage.cards.b.BreathOfDarigaaz.class));
        cards.add(new SetCardInfo("Brion Stoutarm", 187, Rarity.RARE, mage.cards.b.BrionStoutarm.class));
        cards.add(new SetCardInfo("Buried Alive", 74, Rarity.UNCOMMON, mage.cards.b.BuriedAlive.class));
        cards.add(new SetCardInfo("Butcher of Malakir", 75, Rarity.RARE, mage.cards.b.ButcherOfMalakir.class));
        cards.add(new SetCardInfo("Call the Skybreaker", 188, Rarity.RARE, mage.cards.c.CallTheSkybreaker.class));
        cards.add(new SetCardInfo("Celestial Force", 10, Rarity.RARE, mage.cards.c.CelestialForce.class));
        cards.add(new SetCardInfo("Chain Reaction", 113, Rarity.RARE, mage.cards.c.ChainReaction.class));
        cards.add(new SetCardInfo("Champion's Helm", 244, Rarity.RARE, mage.cards.c.ChampionsHelm.class));
        cards.add(new SetCardInfo("Chaos Warp", 114, Rarity.RARE, mage.cards.c.ChaosWarp.class));
        cards.add(new SetCardInfo("Chartooth Cougar", 115, Rarity.COMMON, mage.cards.c.ChartoothCougar.class));
        cards.add(new SetCardInfo("Chorus of the Conclave", 189, Rarity.RARE, mage.cards.c.ChorusOfTheConclave.class));
        cards.add(new SetCardInfo("Chromeshell Crab", 41, Rarity.RARE, mage.cards.c.ChromeshellCrab.class));
        cards.add(new SetCardInfo("Cleansing Beam", 116, Rarity.UNCOMMON, mage.cards.c.CleansingBeam.class));
        cards.add(new SetCardInfo("Cobra Trap", 146, Rarity.UNCOMMON, mage.cards.c.CobraTrap.class));
        cards.add(new SetCardInfo("Collective Voyage", 147, Rarity.RARE, mage.cards.c.CollectiveVoyage.class));
        cards.add(new SetCardInfo("Colossal Might", 190, Rarity.COMMON, mage.cards.c.ColossalMight.class));
        cards.add(new SetCardInfo("Comet Storm", 117, Rarity.MYTHIC, mage.cards.c.CometStorm.class));
        cards.add(new SetCardInfo("Command Tower", 269, Rarity.COMMON, mage.cards.c.CommandTower.class));
        cards.add(new SetCardInfo("Congregate", 11, Rarity.COMMON, mage.cards.c.Congregate.class));
        cards.add(new SetCardInfo("Conundrum Sphinx", 42, Rarity.RARE, mage.cards.c.ConundrumSphinx.class));
        cards.add(new SetCardInfo("Court Hussar", 43, Rarity.UNCOMMON, mage.cards.c.CourtHussar.class));
        cards.add(new SetCardInfo("Crescendo of War", 12, Rarity.RARE, mage.cards.c.CrescendoOfWar.class));
        cards.add(new SetCardInfo("Cultivate", 148, Rarity.COMMON, mage.cards.c.Cultivate.class));
        cards.add(new SetCardInfo("Damia, Sage of Stone", 191, Rarity.MYTHIC, mage.cards.d.DamiaSageOfStone.class));
        cards.add(new SetCardInfo("Dark Hatchling", 76, Rarity.RARE, mage.cards.d.DarkHatchling.class));
        cards.add(new SetCardInfo("Darksteel Ingot", 245, Rarity.COMMON, mage.cards.d.DarksteelIngot.class));
        cards.add(new SetCardInfo("Deadly Recluse", 149, Rarity.COMMON, mage.cards.d.DeadlyRecluse.class));
        cards.add(new SetCardInfo("Deadwood Treefolk", 150, Rarity.UNCOMMON, mage.cards.d.DeadwoodTreefolk.class));
        cards.add(new SetCardInfo("Death by Dragons", 118, Rarity.UNCOMMON, mage.cards.d.DeathByDragons.class));
        cards.add(new SetCardInfo("Death Mutation", 192, Rarity.UNCOMMON, mage.cards.d.DeathMutation.class));
        cards.add(new SetCardInfo("Desecrator Hag", 193, Rarity.COMMON, mage.cards.d.DesecratorHag.class));
        cards.add(new SetCardInfo("Diabolic Tutor", 77, Rarity.UNCOMMON, mage.cards.d.DiabolicTutor.class));
        cards.add(new SetCardInfo("Dimir Aqueduct", 270, Rarity.COMMON, mage.cards.d.DimirAqueduct.class));
        cards.add(new SetCardInfo("Dimir Signet", 246, Rarity.COMMON, mage.cards.d.DimirSignet.class));
        cards.add(new SetCardInfo("Disaster Radius", 119, Rarity.RARE, mage.cards.d.DisasterRadius.class));
        cards.add(new SetCardInfo("Dominus of Fealty", 194, Rarity.RARE, mage.cards.d.DominusOfFealty.class));
        cards.add(new SetCardInfo("Doom Blade", 78, Rarity.COMMON, mage.cards.d.DoomBlade.class));
        cards.add(new SetCardInfo("Dragon Whelp", 120, Rarity.UNCOMMON, mage.cards.d.DragonWhelp.class));
        cards.add(new SetCardInfo("Dread Cacodemon", 79, Rarity.RARE, mage.cards.d.DreadCacodemon.class));
        cards.add(new SetCardInfo("Dreadship Reef", 271, Rarity.UNCOMMON, mage.cards.d.DreadshipReef.class));
        cards.add(new SetCardInfo("Dreamborn Muse", 44, Rarity.RARE, mage.cards.d.DreambornMuse.class));
        cards.add(new SetCardInfo("Dreamstone Hedron", 247, Rarity.UNCOMMON, mage.cards.d.DreamstoneHedron.class));
        cards.add(new SetCardInfo("Duergar Hedge-Mage", 195, Rarity.UNCOMMON, mage.cards.d.DuergarHedgeMage.class));
        cards.add(new SetCardInfo("Earthquake", 121, Rarity.RARE, mage.cards.e.Earthquake.class));
        cards.add(new SetCardInfo("Edric, Spymaster of Trest", 196, Rarity.RARE, mage.cards.e.EdricSpymasterOfTrest.class));
        cards.add(new SetCardInfo("Electrolyze", 197, Rarity.UNCOMMON, mage.cards.e.Electrolyze.class));
        cards.add(new SetCardInfo("Elvish Aberration", 151, Rarity.UNCOMMON, mage.cards.e.ElvishAberration.class));
        cards.add(new SetCardInfo("Eternal Witness", 152, Rarity.UNCOMMON, mage.cards.e.EternalWitness.class));
        cards.add(new SetCardInfo("Evincar's Justice", 80, Rarity.COMMON, mage.cards.e.EvincarsJustice.class));
        cards.add(new SetCardInfo("Evolving Wilds", 272, Rarity.COMMON, mage.cards.e.EvolvingWilds.class));
        cards.add(new SetCardInfo("Explosive Vegetation", 153, Rarity.UNCOMMON, mage.cards.e.ExplosiveVegetation.class));
        cards.add(new SetCardInfo("Extractor Demon", 81, Rarity.RARE, mage.cards.e.ExtractorDemon.class));
        cards.add(new SetCardInfo("Fact or Fiction", 45, Rarity.UNCOMMON, mage.cards.f.FactOrFiction.class));
        cards.add(new SetCardInfo("Fallen Angel", 82, Rarity.RARE, mage.cards.f.FallenAngel.class));
        cards.add(new SetCardInfo("False Prophet", 13, Rarity.RARE, mage.cards.f.FalseProphet.class));
        cards.add(new SetCardInfo("Faultgrinder", 122, Rarity.COMMON, mage.cards.f.Faultgrinder.class));
        cards.add(new SetCardInfo("Fellwar Stone", 248, Rarity.UNCOMMON, mage.cards.f.FellwarStone.class));
        cards.add(new SetCardInfo("Fertilid", 154, Rarity.COMMON, mage.cards.f.Fertilid.class));
        cards.add(new SetCardInfo("Fierce Empath", 155, Rarity.COMMON, mage.cards.f.FierceEmpath.class));
        cards.add(new SetCardInfo("Fire // Ice", 198, Rarity.UNCOMMON, mage.cards.f.FireIce.class));
        cards.add(new SetCardInfo("Firespout", 199, Rarity.UNCOMMON, mage.cards.f.Firespout.class));
        cards.add(new SetCardInfo("Fists of Ironwood", 156, Rarity.COMMON, mage.cards.f.FistsOfIronwood.class));
        cards.add(new SetCardInfo("Flametongue Kavu", 123, Rarity.UNCOMMON, mage.cards.f.FlametongueKavu.class));
        cards.add(new SetCardInfo("Fleshbag Marauder", 83, Rarity.UNCOMMON, mage.cards.f.FleshbagMarauder.class));
        cards.add(new SetCardInfo("Flusterstorm", 46, Rarity.RARE, mage.cards.f.Flusterstorm.class));
        cards.add(new SetCardInfo("Fog Bank", 47, Rarity.UNCOMMON, mage.cards.f.FogBank.class));
        cards.add(new SetCardInfo("Footbottom Feast", 84, Rarity.COMMON, mage.cards.f.FootbottomFeast.class));
        cards.add(new SetCardInfo("Forest", 315, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forest", 316, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forest", 317, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forest", 318, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forgotten Cave", 273, Rarity.COMMON, mage.cards.f.ForgottenCave.class));
        cards.add(new SetCardInfo("Fungal Reaches", 274, Rarity.UNCOMMON, mage.cards.f.FungalReaches.class));
        cards.add(new SetCardInfo("Furnace Whelp", 124, Rarity.UNCOMMON, mage.cards.f.FurnaceWhelp.class));
        cards.add(new SetCardInfo("Garruk Wildspeaker", 157, Rarity.MYTHIC, mage.cards.g.GarrukWildspeaker.class));
        cards.add(new SetCardInfo("Ghave, Guru of Spores", 200, Rarity.MYTHIC, mage.cards.g.GhaveGuruOfSpores.class));
        cards.add(new SetCardInfo("Ghostly Prison", 14, Rarity.UNCOMMON, mage.cards.g.GhostlyPrison.class));
        cards.add(new SetCardInfo("Goblin Cadets", 125, Rarity.UNCOMMON, mage.cards.g.GoblinCadets.class));
        cards.add(new SetCardInfo("Golgari Guildmage", 201, Rarity.UNCOMMON, mage.cards.g.GolgariGuildmage.class));
        cards.add(new SetCardInfo("Golgari Rot Farm", 275, Rarity.COMMON, mage.cards.g.GolgariRotFarm.class));
        cards.add(new SetCardInfo("Golgari Signet", 249, Rarity.COMMON, mage.cards.g.GolgariSignet.class));
        cards.add(new SetCardInfo("Gomazoa", 48, Rarity.UNCOMMON, mage.cards.g.Gomazoa.class));
        cards.add(new SetCardInfo("Gravedigger", 86, Rarity.COMMON, mage.cards.g.Gravedigger.class));
        cards.add(new SetCardInfo("Grave Pact", 85, Rarity.RARE, mage.cards.g.GravePact.class));
        cards.add(new SetCardInfo("Gruul Signet", 250, Rarity.COMMON, mage.cards.g.GruulSignet.class));
        cards.add(new SetCardInfo("Gruul Turf", 276, Rarity.COMMON, mage.cards.g.GruulTurf.class));
        cards.add(new SetCardInfo("Guard Gomazoa", 49, Rarity.UNCOMMON, mage.cards.g.GuardGomazoa.class));
        cards.add(new SetCardInfo("Gwyllion Hedge-Mage", 202, Rarity.UNCOMMON, mage.cards.g.GwyllionHedgeMage.class));
        cards.add(new SetCardInfo("Harmonize", 158, Rarity.UNCOMMON, mage.cards.h.Harmonize.class));
        cards.add(new SetCardInfo("Hex", 87, Rarity.RARE, mage.cards.h.Hex.class));
        cards.add(new SetCardInfo("Homeward Path", 277, Rarity.RARE, mage.cards.h.HomewardPath.class));
        cards.add(new SetCardInfo("Hornet Queen", 159, Rarity.RARE, mage.cards.h.HornetQueen.class));
        cards.add(new SetCardInfo("Hour of Reckoning", 15, Rarity.RARE, mage.cards.h.HourOfReckoning.class));
        cards.add(new SetCardInfo("Howling Mine", 251, Rarity.RARE, mage.cards.h.HowlingMine.class));
        cards.add(new SetCardInfo("Hull Breach", 203, Rarity.COMMON, mage.cards.h.HullBreach.class));
        cards.add(new SetCardInfo("Hunting Pack", 160, Rarity.UNCOMMON, mage.cards.h.HuntingPack.class));
        cards.add(new SetCardInfo("Hydra Omnivore", 161, Rarity.RARE, mage.cards.h.HydraOmnivore.class));
        cards.add(new SetCardInfo("Insurrection", 126, Rarity.RARE, mage.cards.i.Insurrection.class));
        cards.add(new SetCardInfo("Intet, the Dreamer", 204, Rarity.RARE, mage.cards.i.IntetTheDreamer.class));
        cards.add(new SetCardInfo("Invigorate", 162, Rarity.COMMON, mage.cards.i.Invigorate.class));
        cards.add(new SetCardInfo("Island", 303, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Island", 304, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Island", 305, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Island", 306, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Izzet Boilerworks", 278, Rarity.COMMON, mage.cards.i.IzzetBoilerworks.class));
        cards.add(new SetCardInfo("Izzet Chronarch", 205, Rarity.COMMON, mage.cards.i.IzzetChronarch.class));
        cards.add(new SetCardInfo("Izzet Signet", 252, Rarity.COMMON, mage.cards.i.IzzetSignet.class));
        cards.add(new SetCardInfo("Jotun Grunt", 16, Rarity.UNCOMMON, mage.cards.j.JotunGrunt.class));
        cards.add(new SetCardInfo("Journey to Nowhere", 17, Rarity.COMMON, mage.cards.j.JourneyToNowhere.class));
        cards.add(new SetCardInfo("Jwar Isle Refuge", 279, Rarity.UNCOMMON, mage.cards.j.JwarIsleRefuge.class));
        cards.add(new SetCardInfo("Kaalia of the Vast", 206, Rarity.MYTHIC, mage.cards.k.KaaliaOfTheVast.class));
        cards.add(new SetCardInfo("Karador, Ghost Chieftain", 207, Rarity.MYTHIC, mage.cards.k.KaradorGhostChieftain.class));
        cards.add(new SetCardInfo("Kazandu Refuge", 280, Rarity.UNCOMMON, mage.cards.k.KazanduRefuge.class));
        cards.add(new SetCardInfo("Kodama's Reach", 163, Rarity.COMMON, mage.cards.k.KodamasReach.class));
        cards.add(new SetCardInfo("Krosan Tusker", 164, Rarity.COMMON, mage.cards.k.KrosanTusker.class));
        cards.add(new SetCardInfo("Lash Out", 127, Rarity.COMMON, mage.cards.l.LashOut.class));
        cards.add(new SetCardInfo("Lhurgoyf", 165, Rarity.RARE, mage.cards.l.Lhurgoyf.class));
        cards.add(new SetCardInfo("Lightkeeper of Emeria", 18, Rarity.UNCOMMON, mage.cards.l.LightkeeperOfEmeria.class));
        cards.add(new SetCardInfo("Lightning Greaves", 253, Rarity.UNCOMMON, mage.cards.l.LightningGreaves.class));
        cards.add(new SetCardInfo("Living Death", 88, Rarity.RARE, mage.cards.l.LivingDeath.class));
        cards.add(new SetCardInfo("Lonely Sandbar", 281, Rarity.COMMON, mage.cards.l.LonelySandbar.class));
        cards.add(new SetCardInfo("Magmatic Force", 128, Rarity.RARE, mage.cards.m.MagmaticForce.class));
        cards.add(new SetCardInfo("Magus of the Vineyard", 166, Rarity.RARE, mage.cards.m.MagusOfTheVineyard.class));
        cards.add(new SetCardInfo("Malfegor", 208, Rarity.MYTHIC, mage.cards.m.Malfegor.class));
        cards.add(new SetCardInfo("Mana-Charged Dragon", 129, Rarity.RARE, mage.cards.m.ManaChargedDragon.class));
        cards.add(new SetCardInfo("Martyr's Bond", 19, Rarity.RARE, mage.cards.m.MartyrsBond.class));
        cards.add(new SetCardInfo("Memory Erosion", 50, Rarity.RARE, mage.cards.m.MemoryErosion.class));
        cards.add(new SetCardInfo("Minds Aglow", 51, Rarity.RARE, mage.cards.m.MindsAglow.class));
        cards.add(new SetCardInfo("Molten Slagheap", 282, Rarity.UNCOMMON, mage.cards.m.MoltenSlagheap.class));
        cards.add(new SetCardInfo("Monk Realist", 20, Rarity.COMMON, mage.cards.m.MonkRealist.class));
        cards.add(new SetCardInfo("Mortify", 211, Rarity.UNCOMMON, mage.cards.m.Mortify.class));
        cards.add(new SetCardInfo("Mortivore", 89, Rarity.RARE, mage.cards.m.Mortivore.class));
        cards.add(new SetCardInfo("Mother of Runes", 21, Rarity.UNCOMMON, mage.cards.m.MotherOfRunes.class));
        cards.add(new SetCardInfo("Mountain", 311, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mountain", 312, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mountain", 313, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mountain", 314, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mulldrifter", 52, Rarity.COMMON, mage.cards.m.Mulldrifter.class));
        cards.add(new SetCardInfo("Murmurs from Beyond", 53, Rarity.COMMON, mage.cards.m.MurmursFromBeyond.class));
        cards.add(new SetCardInfo("Nantuko Husk", 90, Rarity.UNCOMMON, mage.cards.n.NantukoHusk.class));
        cards.add(new SetCardInfo("Necrogenesis", 212, Rarity.UNCOMMON, mage.cards.n.Necrogenesis.class));
        cards.add(new SetCardInfo("Nemesis Trap", 91, Rarity.UNCOMMON, mage.cards.n.NemesisTrap.class));
        cards.add(new SetCardInfo("Nezumi Graverobber", 92, Rarity.UNCOMMON, mage.cards.n.NezumiGraverobber.class));
        cards.add(new SetCardInfo("Nin, the Pain Artist", 213, Rarity.RARE, mage.cards.n.NinThePainArtist.class));
        cards.add(new SetCardInfo("Nucklavee", 214, Rarity.UNCOMMON, mage.cards.n.Nucklavee.class));
        cards.add(new SetCardInfo("Numot, the Devastator", 215, Rarity.RARE, mage.cards.n.NumotTheDevastator.class));
        cards.add(new SetCardInfo("Oblation", 22, Rarity.RARE, mage.cards.o.Oblation.class));
        cards.add(new SetCardInfo("Oblivion Ring", 23, Rarity.COMMON, mage.cards.o.OblivionRing.class));
        cards.add(new SetCardInfo("Oblivion Stone", 254, Rarity.RARE, mage.cards.o.OblivionStone.class));
        cards.add(new SetCardInfo("Oni of Wild Places", 130, Rarity.UNCOMMON, mage.cards.o.OniOfWildPlaces.class));
        cards.add(new SetCardInfo("Orim's Thunder", 24, Rarity.COMMON, mage.cards.o.OrimsThunder.class));
        cards.add(new SetCardInfo("Oros, the Avenger", 216, Rarity.RARE, mage.cards.o.OrosTheAvenger.class));
        cards.add(new SetCardInfo("Orzhov Basilica", 283, Rarity.COMMON, mage.cards.o.OrzhovBasilica.class));
        cards.add(new SetCardInfo("Orzhov Guildmage", 217, Rarity.UNCOMMON, mage.cards.o.OrzhovGuildmage.class));
        cards.add(new SetCardInfo("Orzhov Signet", 255, Rarity.COMMON, mage.cards.o.OrzhovSignet.class));
        cards.add(new SetCardInfo("Path to Exile", 25, Rarity.UNCOMMON, mage.cards.p.PathToExile.class));
        cards.add(new SetCardInfo("Patron of the Nezumi", 93, Rarity.RARE, mage.cards.p.PatronOfTheNezumi.class));
        cards.add(new SetCardInfo("Penumbra Spider", 167, Rarity.COMMON, mage.cards.p.PenumbraSpider.class));
        cards.add(new SetCardInfo("Perilous Research", 54, Rarity.UNCOMMON, mage.cards.p.PerilousResearch.class));
        cards.add(new SetCardInfo("Plains", 299, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plains", 300, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plains", 301, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plains", 302, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plumeveil", 218, Rarity.UNCOMMON, mage.cards.p.Plumeveil.class));
        cards.add(new SetCardInfo("Pollen Lullaby", 26, Rarity.UNCOMMON, mage.cards.p.PollenLullaby.class));
        cards.add(new SetCardInfo("Prison Term", 27, Rarity.UNCOMMON, mage.cards.p.PrisonTerm.class));
        cards.add(new SetCardInfo("Propaganda", 55, Rarity.UNCOMMON, mage.cards.p.Propaganda.class));
        cards.add(new SetCardInfo("Prophetic Bolt", 219, Rarity.RARE, mage.cards.p.PropheticBolt.class));
        cards.add(new SetCardInfo("Prophetic Prism", 256, Rarity.COMMON, mage.cards.p.PropheticPrism.class));
        cards.add(new SetCardInfo("Punishing Fire", 131, Rarity.UNCOMMON, mage.cards.p.PunishingFire.class));
        cards.add(new SetCardInfo("Pyrohemia", 132, Rarity.UNCOMMON, mage.cards.p.Pyrohemia.class));
        cards.add(new SetCardInfo("Rakdos Carnarium", 284, Rarity.COMMON, mage.cards.r.RakdosCarnarium.class));
        cards.add(new SetCardInfo("Rakdos Signet", 257, Rarity.COMMON, mage.cards.r.RakdosSignet.class));
        cards.add(new SetCardInfo("Rapacious One", 133, Rarity.UNCOMMON, mage.cards.r.RapaciousOne.class));
        cards.add(new SetCardInfo("Ray of Command", 56, Rarity.COMMON, mage.cards.r.RayOfCommand.class));
        cards.add(new SetCardInfo("Razorjaw Oni", 94, Rarity.UNCOMMON, mage.cards.r.RazorjawOni.class));
        cards.add(new SetCardInfo("Reins of Power", 57, Rarity.RARE, mage.cards.r.ReinsOfPower.class));
        cards.add(new SetCardInfo("Reiver Demon", 95, Rarity.RARE, mage.cards.r.ReiverDemon.class));
        cards.add(new SetCardInfo("Relic Crush", 168, Rarity.COMMON, mage.cards.r.RelicCrush.class));
        cards.add(new SetCardInfo("Repulse", 58, Rarity.COMMON, mage.cards.r.Repulse.class));
        cards.add(new SetCardInfo("Return to Dust", 28, Rarity.UNCOMMON, mage.cards.r.ReturnToDust.class));
	cards.add(new SetCardInfo("Riddlekeeper", 59, Rarity.RARE, mage.cards.r.Riddlekeeper.class));
        cards.add(new SetCardInfo("Righteous Cause", 29, Rarity.UNCOMMON, mage.cards.r.RighteousCause.class));
        cards.add(new SetCardInfo("Riku of Two Reflections", 220, Rarity.MYTHIC, mage.cards.r.RikuOfTwoReflections.class));
        cards.add(new SetCardInfo("Rise from the Grave", 96, Rarity.UNCOMMON, mage.cards.r.RiseFromTheGrave.class));
        cards.add(new SetCardInfo("Ruhan of the Fomori", 221, Rarity.MYTHIC, mage.cards.r.RuhanOfTheFomori.class));
        cards.add(new SetCardInfo("Ruination", 134, Rarity.RARE, mage.cards.r.Ruination.class));
        cards.add(new SetCardInfo("Rupture Spire", 285, Rarity.COMMON, mage.cards.r.RuptureSpire.class));
        cards.add(new SetCardInfo("Sakura-Tribe Elder", 169, Rarity.COMMON, mage.cards.s.SakuraTribeElder.class));
        cards.add(new SetCardInfo("Savage Twister", 222, Rarity.UNCOMMON, mage.cards.s.SavageTwister.class));
        cards.add(new SetCardInfo("Scattering Stroke", 60, Rarity.UNCOMMON, mage.cards.s.ScatteringStroke.class));
        cards.add(new SetCardInfo("Scavenging Ooze", 170, Rarity.RARE, mage.cards.s.ScavengingOoze.class));
        cards.add(new SetCardInfo("Scythe Specter", 97, Rarity.RARE, mage.cards.s.ScytheSpecter.class));
        cards.add(new SetCardInfo("Secluded Steppe", 286, Rarity.COMMON, mage.cards.s.SecludedSteppe.class));
        cards.add(new SetCardInfo("Selesnya Evangel", 223, Rarity.COMMON, mage.cards.s.SelesnyaEvangel.class));
        cards.add(new SetCardInfo("Selesnya Guildmage", 224, Rarity.UNCOMMON, mage.cards.s.SelesnyaGuildmage.class));
        cards.add(new SetCardInfo("Selesnya Sanctuary", 287, Rarity.COMMON, mage.cards.s.SelesnyaSanctuary.class));
        cards.add(new SetCardInfo("Selesnya Signet", 258, Rarity.COMMON, mage.cards.s.SelesnyaSignet.class));
        cards.add(new SetCardInfo("Serra Angel", 30, Rarity.UNCOMMON, mage.cards.s.SerraAngel.class));
        cards.add(new SetCardInfo("Sewer Nemesis", 98, Rarity.RARE, mage.cards.s.SewerNemesis.class));
        cards.add(new SetCardInfo("Shared Trauma", 99, Rarity.RARE, mage.cards.s.SharedTrauma.class));
        cards.add(new SetCardInfo("Shattered Angel", 31, Rarity.UNCOMMON, mage.cards.s.ShatteredAngel.class));
        cards.add(new SetCardInfo("Shriekmaw", 100, Rarity.UNCOMMON, mage.cards.s.Shriekmaw.class));
        cards.add(new SetCardInfo("Sigil Captain", 225, Rarity.UNCOMMON, mage.cards.s.SigilCaptain.class));
        cards.add(new SetCardInfo("Sign in Blood", 101, Rarity.COMMON, mage.cards.s.SignInBlood.class));
        cards.add(new SetCardInfo("Simic Growth Chamber", 288, Rarity.COMMON, mage.cards.s.SimicGrowthChamber.class));
        cards.add(new SetCardInfo("Simic Signet", 259, Rarity.COMMON, mage.cards.s.SimicSignet.class));
        cards.add(new SetCardInfo("Simic Sky Swallower", 226, Rarity.RARE, mage.cards.s.SimicSkySwallower.class));
        cards.add(new SetCardInfo("Skullbriar, the Walking Grave", 227, Rarity.RARE, mage.cards.s.SkullbriarTheWalkingGrave.class));
        cards.add(new SetCardInfo("Skullclamp", 260, Rarity.UNCOMMON, mage.cards.s.Skullclamp.class));
        cards.add(new SetCardInfo("Skyscribing", 61, Rarity.UNCOMMON, mage.cards.s.Skyscribing.class));
        cards.add(new SetCardInfo("Slipstream Eel", 62, Rarity.COMMON, mage.cards.s.SlipstreamEel.class));
        cards.add(new SetCardInfo("Solemn Simulacrum", 262, Rarity.RARE, mage.cards.s.SolemnSimulacrum.class));
        cards.add(new SetCardInfo("Sol Ring", 261, Rarity.UNCOMMON, mage.cards.s.SolRing.class));
        cards.add(new SetCardInfo("Soul Snare", 32, Rarity.UNCOMMON, mage.cards.s.SoulSnare.class));
        cards.add(new SetCardInfo("Spawnwrithe", 171, Rarity.RARE, mage.cards.s.Spawnwrithe.class));
        cards.add(new SetCardInfo("Spell Crumple", 63, Rarity.UNCOMMON, mage.cards.s.SpellCrumple.class));
        cards.add(new SetCardInfo("Spike Feeder", 172, Rarity.UNCOMMON, mage.cards.s.SpikeFeeder.class));
        cards.add(new SetCardInfo("Spitebellows", 135, Rarity.UNCOMMON, mage.cards.s.Spitebellows.class));
        cards.add(new SetCardInfo("Spurnmage Advocate", 33, Rarity.UNCOMMON, mage.cards.s.SpurnmageAdvocate.class));
        cards.add(new SetCardInfo("Squallmonger", 173, Rarity.UNCOMMON, mage.cards.s.Squallmonger.class));
        cards.add(new SetCardInfo("Stitch Together", 102, Rarity.UNCOMMON, mage.cards.s.StitchTogether.class));
        cards.add(new SetCardInfo("Storm Herd", 34, Rarity.RARE, mage.cards.s.StormHerd.class));
        cards.add(new SetCardInfo("Stranglehold", 136, Rarity.RARE, mage.cards.s.Stranglehold.class));
        cards.add(new SetCardInfo("Sulfurous Blast", 137, Rarity.UNCOMMON, mage.cards.s.SulfurousBlast.class));
        cards.add(new SetCardInfo("Svogthos, the Restless Tomb", 289, Rarity.UNCOMMON, mage.cards.s.SvogthosTheRestlessTomb.class));
        cards.add(new SetCardInfo("Swamp", 307, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swamp", 308, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swamp", 309, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swamp", 310, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Symbiotic Wurm", 174, Rarity.RARE, mage.cards.s.SymbioticWurm.class));
        cards.add(new SetCardInfo("Syphon Flesh", 103, Rarity.UNCOMMON, mage.cards.s.SyphonFlesh.class));
        cards.add(new SetCardInfo("Syphon Mind", 104, Rarity.COMMON, mage.cards.s.SyphonMind.class));
        cards.add(new SetCardInfo("Szadek, Lord of Secrets", 228, Rarity.RARE, mage.cards.s.SzadekLordOfSecrets.class));
        cards.add(new SetCardInfo("Tariel, Reckoner of Souls", 229, Rarity.MYTHIC, mage.cards.t.TarielReckonerOfSouls.class));
        cards.add(new SetCardInfo("Temple of the False God", 290, Rarity.UNCOMMON, mage.cards.t.TempleOfTheFalseGod.class));
        cards.add(new SetCardInfo("Teneb, the Harvester", 230, Rarity.RARE, mage.cards.t.TenebTheHarvester.class));
        cards.add(new SetCardInfo("Terminate", 231, Rarity.COMMON, mage.cards.t.Terminate.class));
        cards.add(new SetCardInfo("Terramorphic Expanse", 291, Rarity.COMMON, mage.cards.t.TerramorphicExpanse.class));
        cards.add(new SetCardInfo("The Mimeoplasm", 210, Rarity.MYTHIC, mage.cards.t.TheMimeoplasm.class));
        cards.add(new SetCardInfo("Trade Secrets", 64, Rarity.RARE, mage.cards.t.TradeSecrets.class));
        cards.add(new SetCardInfo("Tranquil Thicket", 292, Rarity.COMMON, mage.cards.t.TranquilThicket.class));
        cards.add(new SetCardInfo("Trench Gorger", 65, Rarity.RARE, mage.cards.t.TrenchGorger.class));
        cards.add(new SetCardInfo("Tribute to the Wild", 175, Rarity.UNCOMMON, mage.cards.t.TributeToTheWild.class));
        cards.add(new SetCardInfo("Triskelavus", 263, Rarity.RARE, mage.cards.t.Triskelavus.class));
        cards.add(new SetCardInfo("Troll Ascetic", 176, Rarity.RARE, mage.cards.t.TrollAscetic.class));
        cards.add(new SetCardInfo("Unnerve", 105, Rarity.COMMON, mage.cards.u.Unnerve.class));
        cards.add(new SetCardInfo("Valley Rannet", 232, Rarity.COMMON, mage.cards.v.ValleyRannet.class));
        cards.add(new SetCardInfo("Vampire Nighthawk", 106, Rarity.UNCOMMON, mage.cards.v.VampireNighthawk.class));
        cards.add(new SetCardInfo("Vedalken Plotter", 66, Rarity.UNCOMMON, mage.cards.v.VedalkenPlotter.class));
        cards.add(new SetCardInfo("Vengeful Rebirth", 233, Rarity.UNCOMMON, mage.cards.v.VengefulRebirth.class));
        cards.add(new SetCardInfo("Veteran Explorer", 177, Rarity.UNCOMMON, mage.cards.v.VeteranExplorer.class));
        cards.add(new SetCardInfo("Vish Kal, Blood Arbiter", 234, Rarity.RARE, mage.cards.v.VishKalBloodArbiter.class));
        cards.add(new SetCardInfo("Vision Skeins", 67, Rarity.COMMON, mage.cards.v.VisionSkeins.class));
        cards.add(new SetCardInfo("Vivid Crag", 293, Rarity.UNCOMMON, mage.cards.v.VividCrag.class));
        cards.add(new SetCardInfo("Vivid Creek", 294, Rarity.UNCOMMON, mage.cards.v.VividCreek.class));
        cards.add(new SetCardInfo("Vivid Grove", 295, Rarity.UNCOMMON, mage.cards.v.VividGrove.class));
        cards.add(new SetCardInfo("Vivid Marsh", 296, Rarity.UNCOMMON, mage.cards.v.VividMarsh.class));
        cards.add(new SetCardInfo("Vivid Meadow", 297, Rarity.UNCOMMON, mage.cards.v.VividMeadow.class));
        cards.add(new SetCardInfo("Voice of All", 35, Rarity.RARE, mage.cards.v.VoiceOfAll.class));
        cards.add(new SetCardInfo("Vorosh, the Hunter", 235, Rarity.RARE, mage.cards.v.VoroshTheHunter.class));
        cards.add(new SetCardInfo("Vow of Duty", 36, Rarity.UNCOMMON, mage.cards.v.VowOfDuty.class));
        cards.add(new SetCardInfo("Vow of Flight", 68, Rarity.UNCOMMON, mage.cards.v.VowOfFlight.class));
        cards.add(new SetCardInfo("Vow of Lightning", 138, Rarity.UNCOMMON, mage.cards.v.VowOfLightning.class));
        cards.add(new SetCardInfo("Vow of Malice", 107, Rarity.UNCOMMON, mage.cards.v.VowOfMalice.class));
        cards.add(new SetCardInfo("Vow of Wildness", 178, Rarity.UNCOMMON, mage.cards.v.VowOfWildness.class));
        cards.add(new SetCardInfo("Vulturous Zombie", 236, Rarity.RARE, mage.cards.v.VulturousZombie.class));
        cards.add(new SetCardInfo("Wall of Denial", 237, Rarity.UNCOMMON, mage.cards.w.WallOfDenial.class));
        cards.add(new SetCardInfo("Wall of Omens", 37, Rarity.UNCOMMON, mage.cards.w.WallOfOmens.class));
        cards.add(new SetCardInfo("Whirlpool Whelm", 69, Rarity.COMMON, mage.cards.w.WhirlpoolWhelm.class));
        cards.add(new SetCardInfo("Wild Ricochet", 139, Rarity.RARE, mage.cards.w.WildRicochet.class));
        cards.add(new SetCardInfo("Windborn Muse", 38, Rarity.RARE, mage.cards.w.WindbornMuse.class));
        cards.add(new SetCardInfo("Windfall", 70, Rarity.UNCOMMON, mage.cards.w.Windfall.class));
        cards.add(new SetCardInfo("Wonder", 71, Rarity.UNCOMMON, mage.cards.w.Wonder.class));
        cards.add(new SetCardInfo("Wrecking Ball", 238, Rarity.COMMON, mage.cards.w.WreckingBall.class));
        cards.add(new SetCardInfo("Wrexial, the Risen Deep", 239, Rarity.MYTHIC, mage.cards.w.WrexialTheRisenDeep.class));
        cards.add(new SetCardInfo("Yavimaya Elder", 179, Rarity.COMMON, mage.cards.y.YavimayaElder.class));
        cards.add(new SetCardInfo("Zedruu the Greathearted", 240, Rarity.MYTHIC, mage.cards.z.ZedruuTheGreathearted.class));
        cards.add(new SetCardInfo("Zoetic Cavern", 298, Rarity.UNCOMMON, mage.cards.z.ZoeticCavern.class));
    }

}