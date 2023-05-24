package coda.glort.client.model;

import coda.glort.common.entities.Croaker;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class CroakerModel<T extends Croaker> extends EntityModel<T> {
	private final ModelPart head;
	private final ModelPart Body;
	private final ModelPart L_arm;
	private final ModelPart R_arm;
	private final ModelPart L_leg;
	private final ModelPart R_leg;

	public CroakerModel(ModelPart root) {
		this.head = root.getChild("head");
		this.Body = root.getChild("Body");
		this.L_arm = root.getChild("L_arm");
		this.R_arm = root.getChild("R_arm");
		this.L_leg = root.getChild("L_leg");
		this.R_leg = root.getChild("R_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 32).addBox(-6.0F, -3.0F, -4.0F, 12.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(32, 24).addBox(-6.0F, -4.0F, -4.0F, 12.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition Tongue = head.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(18, 63).addBox(-2.0F, -0.5F, -3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.5F, 3.0F));

		PartDefinition tongue_tip = Tongue.addOrReplaceChild("tongue_tip", CubeListBuilder.create().texOffs(0, 60).addBox(-3.0F, -1.5F, -6.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 21).addBox(-6.0F, -4.0F, -6.0F, 12.0F, 3.0F, 8.0F, new CubeDeformation(0.025F))
		.texOffs(0, 103).addBox(-6.0F, -7.0F, -6.0F, 12.0F, 3.0F, 8.0F, new CubeDeformation(0.025F))
		.texOffs(40, 17).mirror().addBox(-6.0F, -6.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 17).addBox(3.0F, -6.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(34, 0).addBox(-6.0F, -1.0F, -6.0F, 12.0F, 1.0F, 8.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, -3.0F, 2.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -21.0F, -5.0F, 12.0F, 11.0F, 10.0F, new CubeDeformation(0.025F))
		.texOffs(0, 76).addBox(-6.0F, -10.0F, -5.0F, 12.0F, 7.0F, 10.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition L_arm = partdefinition.addOrReplaceChild("L_arm", CubeListBuilder.create().texOffs(0, 43).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 3.0F, 1.0F));

		PartDefinition R_arm = partdefinition.addOrReplaceChild("R_arm", CubeListBuilder.create().texOffs(0, 43).addBox(0.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 3.0F, 1.0F));

		PartDefinition L_leg = partdefinition.addOrReplaceChild("L_leg", CubeListBuilder.create().texOffs(35, 38).mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(49, 38).mirror().addBox(-4.5F, 9.95F, -6.5F, 7.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, 14.0F, 0.5F));

		PartDefinition R_leg = partdefinition.addOrReplaceChild("R_leg", CubeListBuilder.create().texOffs(35, 38).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(49, 38).addBox(-2.5F, 9.95F, -6.5F, 7.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 14.0F, 0.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		L_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		R_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		L_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		R_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}