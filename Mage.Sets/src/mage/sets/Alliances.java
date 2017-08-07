package mage.sets;

import mage.cards.ExpansionSet;
import mage.cards.a.AesthirGlider;
import mage.cards.a.AgentOfStromgald;
import mage.cards.b.BalduvianWarMakers;
import mage.cards.c.CarrierPigeons;
import mage.cards.e.EnslavedScout;
import mage.cards.f.FeveredStrength;
import mage.cards.g.GorillaBerserkers;
import mage.cards.g.GorillaShaman;
import mage.cards.i.InsidiousBookworms;
import mage.cards.l.LimDulsHighGuard;
import mage.cards.p.PhyrexianWarBeast;
import mage.cards.r.RoyalHerbalist;
import mage.cards.s.SoldeviAdnate;
import mage.cards.s.SoldeviSage;
import mage.cards.s.StormShaman;
import mage.cards.s.SwampMosquito;
import mage.cards.w.WhipVine;
import mage.constants.Rarity;
import mage.constants.SetType;

public class Alliances extends ExpansionSet {
    private static final Alliances instance = new Alliances();

    public static Alliances getInstance() {
        return instance;
    }

    private Alliances() {
        super("Alliances", "ALL", ExpansionSet.buildDate(1996, 6, 10), SetType.EXPANSION);
        this.blockName = "Ice Age";
        this.parentSet = IceAge.getInstance();
        this.hasBasicLands = false;
        this.hasBoosters = true;
        this.numBoosterLands = 0;
        this.numBoosterCommon = 8;
        this.numBoosterUncommon = 3;
        this.numBoosterRare = 1;
        this.ratioBoosterMythic = 0;
        cards.add(new SetCardInfo("Aesthir Glider", 156, Rarity.COMMON, AesthirGlider.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Aesthir Glider", 157, Rarity.COMMON, AesthirGlider.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Agent of Stromgald", 94, Rarity.COMMON, AgentOfStromgald.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Agent of Stromgald", 95, Rarity.COMMON, AgentOfStromgald.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Arcane Denial", 32, Rarity.COMMON, mage.cards.a.ArcaneDenial.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Arcane Denial", 33, Rarity.COMMON, mage.cards.a.ArcaneDenial.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Astrolabe", 159, Rarity.COMMON, mage.cards.a.Astrolabe.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Astrolabe", 160, Rarity.COMMON, mage.cards.a.Astrolabe.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Balduvian Dead", 1, Rarity.UNCOMMON, mage.cards.b.BalduvianDead.class));
        cards.add(new SetCardInfo("Balduvian Horde", 96, Rarity.RARE, mage.cards.b.BalduvianHorde.class));
        cards.add(new SetCardInfo("Balduvian Trading Post", 182, Rarity.RARE, mage.cards.b.BalduvianTradingPost.class));
        cards.add(new SetCardInfo("Balduvian War-Makers", 97, Rarity.COMMON, BalduvianWarMakers.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Balduvian War-Makers", 98, Rarity.COMMON, BalduvianWarMakers.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Bounty of the Hunt", 63, Rarity.UNCOMMON, mage.cards.b.BountyOfTheHunt.class));
        cards.add(new SetCardInfo("Browse", 38, Rarity.UNCOMMON, mage.cards.b.Browse.class));
        cards.add(new SetCardInfo("Burnout", 101, Rarity.UNCOMMON, mage.cards.b.Burnout.class));
        cards.add(new SetCardInfo("Carrier Pigeons", 125, Rarity.COMMON, CarrierPigeons.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Carrier Pigeons", 126, Rarity.COMMON, CarrierPigeons.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Contagion", 4, Rarity.UNCOMMON, mage.cards.c.Contagion.class));
        cards.add(new SetCardInfo("Deadly Insect", 64, Rarity.COMMON, mage.cards.d.DeadlyInsect.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Deadly Insect", 65, Rarity.COMMON, mage.cards.d.DeadlyInsect.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Death Spark", 103, Rarity.UNCOMMON, mage.cards.d.DeathSpark.class));
        cards.add(new SetCardInfo("Diminishing Returns", 39, Rarity.RARE, mage.cards.d.DiminishingReturns.class));
        cards.add(new SetCardInfo("Dystopia", 6, Rarity.RARE, mage.cards.d.Dystopia.class));
        cards.add(new SetCardInfo("Elvish Bard", 66, Rarity.UNCOMMON, mage.cards.e.ElvishBard.class));
        cards.add(new SetCardInfo("Elvish Ranger", 67, Rarity.COMMON, mage.cards.e.ElvishRanger.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Elvish Ranger", 68, Rarity.COMMON, mage.cards.e.ElvishRanger.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Elvish Spirit Guide", 69, Rarity.UNCOMMON, mage.cards.e.ElvishSpiritGuide.class));
        cards.add(new SetCardInfo("Enslaved Scout", 104, Rarity.COMMON, EnslavedScout.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Enslaved Scout", 105, Rarity.COMMON, EnslavedScout.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Exile", 129, Rarity.RARE, mage.cards.e.Exile.class));
        cards.add(new SetCardInfo("False Demise", 40, Rarity.COMMON, mage.cards.f.FalseDemise.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("False Demise", 41, Rarity.COMMON, mage.cards.f.FalseDemise.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Feast or Famine", 8, Rarity.COMMON, mage.cards.f.FeastOrFamine.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Feast or Famine", 9, Rarity.COMMON, mage.cards.f.FeastOrFamine.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Fevered Strength", 10, Rarity.COMMON, FeveredStrength.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Fevered Strength", 11, Rarity.COMMON, FeveredStrength.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Floodwater Dam", 161, Rarity.RARE, mage.cards.f.FloodwaterDam.class));
        cards.add(new SetCardInfo("Force of Will", 42, Rarity.UNCOMMON, mage.cards.f.ForceOfWill.class));
        cards.add(new SetCardInfo("Gorilla Berserkers", 75, Rarity.COMMON, GorillaBerserkers.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Gorilla Berserkers", 76, Rarity.COMMON, GorillaBerserkers.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Gorilla Chieftain", 77, Rarity.COMMON, mage.cards.g.GorillaChieftain.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Gorilla Chieftain", 78, Rarity.COMMON, mage.cards.g.GorillaChieftain.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Gorilla Shaman", 106, Rarity.COMMON, GorillaShaman.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Gorilla Shaman", 107, Rarity.UNCOMMON, GorillaShaman.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Gorilla War Cry", 108, Rarity.COMMON, mage.cards.g.GorillaWarCry.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Gorilla War Cry", 109, Rarity.COMMON, mage.cards.g.GorillaWarCry.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Guerrilla Tactics", 110, Rarity.COMMON, mage.cards.g.GuerrillaTactics.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Guerrilla Tactics", 111, Rarity.COMMON, mage.cards.g.GuerrillaTactics.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Heart of Yavimaya", 183, Rarity.RARE, mage.cards.h.HeartOfYavimaya.class));
        cards.add(new SetCardInfo("Helm of Obedience", 163, Rarity.RARE, mage.cards.h.HelmOfObedience.class));
        cards.add(new SetCardInfo("Inheritance", 130, Rarity.UNCOMMON, mage.cards.i.Inheritance.class));
        cards.add(new SetCardInfo("Insidious Bookworms", 12, Rarity.COMMON, InsidiousBookworms.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Insidious Bookworms", 13, Rarity.COMMON, InsidiousBookworms.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Juniper Order Advocate", 132, Rarity.UNCOMMON, mage.cards.j.JuniperOrderAdvocate.class));
        cards.add(new SetCardInfo("Kaysa", 80, Rarity.RARE, mage.cards.k.Kaysa.class));
        cards.add(new SetCardInfo("Keeper of Tresserhorn", 14, Rarity.RARE, mage.cards.k.KeeperOfTresserhorn.class));
        cards.add(new SetCardInfo("Kjeldoran Outpost", 184, Rarity.RARE, mage.cards.k.KjeldoranOutpost.class));
        cards.add(new SetCardInfo("Lake of the Dead", 185, Rarity.RARE, mage.cards.l.LakeOfTheDead.class));
        cards.add(new SetCardInfo("Library of Lat-Nam", 47, Rarity.RARE, mage.cards.l.LibraryOfLatNam.class));
        cards.add(new SetCardInfo("Lim-Dul's High Guard", 17, Rarity.COMMON, LimDulsHighGuard.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Lim-Dul's High Guard", 18, Rarity.COMMON, LimDulsHighGuard.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Lim-Dul's Paladin", 191, Rarity.UNCOMMON, mage.cards.l.LimDulsPaladin.class));
        cards.add(new SetCardInfo("Lim-Dul's Vault", 192, Rarity.UNCOMMON, mage.cards.l.LimDulsVault.class));
        cards.add(new SetCardInfo("Lord of Tresserhorn", 193, Rarity.RARE, mage.cards.l.LordOfTresserhorn.class));
        cards.add(new SetCardInfo("Mystic Compass", 166, Rarity.UNCOMMON, mage.cards.m.MysticCompass.class));
        cards.add(new SetCardInfo("Phelddagrif", 196, Rarity.RARE, mage.cards.p.Phelddagrif.class));
        cards.add(new SetCardInfo("Phyrexian Devourer", 167, Rarity.RARE, mage.cards.p.PhyrexianDevourer.class));
        cards.add(new SetCardInfo("Phyrexian War Beast", 169, Rarity.COMMON, PhyrexianWarBeast.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Phyrexian War Beast", 170, Rarity.COMMON, PhyrexianWarBeast.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Pillage", 113, Rarity.UNCOMMON, mage.cards.p.Pillage.class));
        cards.add(new SetCardInfo("Pyrokinesis", 115, Rarity.UNCOMMON, mage.cards.p.Pyrokinesis.class));
        cards.add(new SetCardInfo("Reinforcements", 142, Rarity.COMMON, mage.cards.r.Reinforcements.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Reinforcements", 143, Rarity.COMMON, mage.cards.r.Reinforcements.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Reprisal", 144, Rarity.COMMON, mage.cards.r.Reprisal.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Reprisal", 145, Rarity.COMMON, mage.cards.r.Reprisal.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ritual of the Machine", 24, Rarity.RARE, mage.cards.r.RitualOfTheMachine.class));
        cards.add(new SetCardInfo("Royal Herbalist", 147, Rarity.COMMON, RoyalHerbalist.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Royal Herbalist", 148, Rarity.COMMON, RoyalHerbalist.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("School of the Unseen", 186, Rarity.UNCOMMON, mage.cards.s.SchoolOfTheUnseen.class));
        cards.add(new SetCardInfo("Seasoned Tactician", 150, Rarity.UNCOMMON, mage.cards.s.SeasonedTactician.class));
        cards.add(new SetCardInfo("Sheltered Valley", 187, Rarity.RARE, mage.cards.s.ShelteredValley.class));
        cards.add(new SetCardInfo("Shield Sphere", 172, Rarity.UNCOMMON, mage.cards.s.ShieldSphere.class));
        cards.add(new SetCardInfo("Soldevi Adnate", 25, Rarity.COMMON, SoldeviAdnate.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Soldevi Adnate", 26, Rarity.COMMON, SoldeviAdnate.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Soldevi Digger", 174, Rarity.RARE, mage.cards.s.SoldeviDigger.class));
        cards.add(new SetCardInfo("Soldevi Excavations", 188, Rarity.RARE, mage.cards.s.SoldeviExcavations.class));
        cards.add(new SetCardInfo("Soldevi Sage", 51, Rarity.COMMON, SoldeviSage.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Soldevi Sage", 52, Rarity.COMMON, SoldeviSage.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Soldier of Fortune", 117, Rarity.UNCOMMON, mage.cards.s.SoldierOfFortune.class));
        cards.add(new SetCardInfo("Sol Grail", 173, Rarity.UNCOMMON, mage.cards.s.SolGrail.class));
        cards.add(new SetCardInfo("Storm Cauldron", 179, Rarity.RARE, mage.cards.s.StormCauldron.class));
        cards.add(new SetCardInfo("Storm Crow", 54, Rarity.COMMON, mage.cards.s.StormCrow.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Storm Crow", 55, Rarity.COMMON, mage.cards.s.StormCrow.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Storm Shaman", 118, Rarity.COMMON, StormShaman.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Storm Shaman", 119, Rarity.UNCOMMON, StormShaman.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Sustaining Spirit", 151, Rarity.RARE, mage.cards.s.SustainingSpirit.class));
        cards.add(new SetCardInfo("Swamp Mosquito", 30, Rarity.COMMON, SwampMosquito.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Swamp Mosquito", 31, Rarity.COMMON, SwampMosquito.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Thawing Glaciers", 189, Rarity.RARE, mage.cards.t.ThawingGlaciers.class));
        cards.add(new SetCardInfo("Thought Lash", 58, Rarity.RARE, mage.cards.t.ThoughtLash.class));
        cards.add(new SetCardInfo("Tornado", 86, Rarity.RARE, mage.cards.t.Tornado.class));
        cards.add(new SetCardInfo("Viscerid Armor", 60, Rarity.COMMON, mage.cards.v.VisceridArmor.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Viscerid Armor", 61, Rarity.COMMON, mage.cards.v.VisceridArmor.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Wandering Mage", 198, Rarity.RARE, mage.cards.w.WanderingMage.class));
        cards.add(new SetCardInfo("Whip Vine", 89, Rarity.COMMON, WhipVine.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Whip Vine", 90, Rarity.COMMON, WhipVine.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Wild Aesthir", 154, Rarity.COMMON, mage.cards.w.WildAesthir.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Wild Aesthir", 155, Rarity.COMMON, mage.cards.w.WildAesthir.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Yavimaya Ancients", 91, Rarity.COMMON, mage.cards.y.YavimayaAncients.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Yavimaya Ancients", 92, Rarity.COMMON, mage.cards.y.YavimayaAncients.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Yavimaya Ants", 93, Rarity.UNCOMMON, mage.cards.y.YavimayaAnts.class));
    }
}
